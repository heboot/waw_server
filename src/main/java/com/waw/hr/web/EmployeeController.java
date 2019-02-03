package com.waw.hr.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waw.hr.CommonValue;
import com.waw.hr.core.MValue;
import com.waw.hr.core.ROLE;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;
import com.waw.hr.entity.EmployeeSignLog;
import com.waw.hr.response.GetEmployeeListResponse;
import com.waw.hr.response.GetEmployeeSignLogListResponse;
import com.waw.hr.service.AdminUserService;
import com.waw.hr.service.EmployeeService;
import com.waw.hr.service.EmployeeSignLogService;
import com.waw.hr.utils.JWTUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.waw.hr.core.ResultCode.UNAUTHORIZED;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @Resource
    private EmployeeSignLogService employeeSignLogService;

    @Resource
    private AdminUserService adminUserService;

    @PostMapping("/doEmployeeLogin")
    public Result doEmployeeLogin(@RequestParam String mobile,
                                  @RequestParam String code) {
        return employeeService.doLogin(mobile, code);
    }

    /**
     * 更新员工状态
     *
     * @param token
     * @param employeeId
     * @param status
     * @return
     */
    @PostMapping("/updateEmployeeStatus")
    public Result updateEmployeeStatus(@RequestParam String token, @RequestParam Integer employeeId,
                                       @RequestParam Integer status) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));
        if (adminUser.getRole() == ROLE.ROLE_ADMIN) {
            int result = employeeService.updateEmployeeStatus(employeeId, status);
            if (result > 0) {
                return ResultGenerator.genSuccessResult(MValue.MESSAGE_UPDATE_SUC);
            }
            return ResultGenerator.genFailResult(MValue.MESSAGE_UPDATE_FAIL);
        }
        return ResultGenerator.genFailResult(MValue.MESSAGE_ROLE_ERROR);
    }

    /**
     * 更新员工工作状态
     *
     * @param token
     * @param employeeId
     * @param status     0 未入场，1 已入场 2，离职
     * @return
     */
    @PostMapping("/updateEmployeeJobStatus")
    public Result updateEmployeeJobStatus(@RequestParam String token, @RequestParam Integer employeeId,
                                          @RequestParam Integer status) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));
        if (adminUser.getRole() == ROLE.ROLE_ADMIN) {
            int result = employeeService.updateEmployeeJobStatus(employeeId, status);
            if (result > 0) {
                return ResultGenerator.genSuccessResult(MValue.MESSAGE_UPDATE_SUC);
            }
            return ResultGenerator.genFailResult(MValue.MESSAGE_UPDATE_FAIL);
        }
        return ResultGenerator.genFailResult(MValue.MESSAGE_ROLE_ERROR);
    }

    /**
     * 更新员工提现状态
     *
     * @param token
     * @param employeeId
     * @param status     0 不可提现  1 可提现
     * @return
     */
    @PostMapping("/updateEmployeeCashStatus")
    public Result updateEmployeeCashStatus(@RequestParam String token, @RequestParam Integer employeeId,
                                           @RequestParam Integer status) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));
        if (adminUser.getRole() == ROLE.ROLE_ADMIN) {
            int result = employeeService.updateEmployeeCashStatus(employeeId, status);
            if (result > 0) {
                return ResultGenerator.genSuccessResult(MValue.MESSAGE_UPDATE_SUC);
            }
            return ResultGenerator.genFailResult(MValue.MESSAGE_UPDATE_FAIL);
        }
        return ResultGenerator.genFailResult(MValue.MESSAGE_ROLE_ERROR);
    }

    /**
     * 获取员工列表
     *
     * @param token
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/getEmployeeList")
    public Result getEmployeeList(@RequestParam String token, @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "20") Integer limit) {

        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        PageHelper.startPage(page, limit);
        List<Employee> enterprises = null;

        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));
        if (adminUser.getRole() == ROLE.ROLE_ADMIN) {
            enterprises = employeeService.getEmployeeList();
        } else if (adminUser.getRole() == ROLE.ROLE_EDITOR) {
            enterprises = employeeService.getEmployeeListByParentID(adminUser.getId());
        } else if (adminUser.getRole() == ROLE.ROLE_BROKER) {
            enterprises = employeeService.getEmployeeListByBrokerId(adminUser.getId());
        }


        PageInfo<Employee> pageInfo = new PageInfo<>(enterprises);
        return ResultGenerator.genSuccessResult(new GetEmployeeListResponse(page, limit, (int) pageInfo.getTotal(), pageInfo.getList()));
    }


    /**
     * 获取员工打卡列表
     *
     * @param token
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/getEmployeeSignLogList")
    public Result getEmployeeSignLogList(@RequestParam String token, @RequestParam(defaultValue = "1") Integer page,
                                         @RequestParam(defaultValue = "20") Integer size) {

        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        PageHelper.startPage(page, size);

        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));

        return employeeSignLogService.getEmployeeSignLogList(adminUser.getRole(), adminUser.getId(), page, size);

    }

    /**
     * 根据员工ID获取打卡列表
     *
     * @param token
     * @param employeeId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/getEmployeeSignLogListByEmployeeId")
    public Result getEmployeeSignLogListByEmployeeId(@RequestParam String token, @RequestParam Integer employeeId, @RequestParam(defaultValue = "1") Integer page,
                                                     @RequestParam(defaultValue = "20") Integer size) {

        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        PageHelper.startPage(page, size);
        List<EmployeeSignLog> employeeSignLogList = employeeSignLogService.getEmployeeSignLogListByEmployeeId(employeeId);
        PageInfo<EmployeeSignLog> pageInfo = new PageInfo<>(employeeSignLogList);
        return ResultGenerator.genSuccessResult(new GetEmployeeSignLogListResponse(page, size, (int) pageInfo.getTotal(), pageInfo.getList()));
    }

}
