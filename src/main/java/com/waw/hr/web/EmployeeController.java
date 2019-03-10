package com.waw.hr.web;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waw.hr.CommonValue;
import com.waw.hr.core.*;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;
import com.waw.hr.entity.EmployeeSignLog;
import com.waw.hr.response.*;
import com.waw.hr.service.AdminUserService;
import com.waw.hr.service.EmployeeService;
import com.waw.hr.service.EmployeeSignLogService;
import com.waw.hr.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.waw.hr.core.ResultCode.UNAUTHORIZED;

@RestController
@RequestMapping(value = {"/employee", "app/employee"})
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @Resource
    private EmployeeSignLogService employeeSignLogService;

    @Resource
    private AdminUserService adminUserService;

    @Value("${spring.profiles.active}")
    private String env;//当前激活的配置文件


    /**
     * 登录
     *
     * @param mobile
     * @param code
     * @return
     */
    @PostMapping("/login")
    public Result doEmployeeLogin(@RequestParam String mobile,
                                  @RequestParam String code) {
        if (!"dev".equals(env)) { //开发环境忽略签名认证
            try {
                AVOSCloud.verifySMSCode(code, mobile);
                return employeeService.doLogin(mobile, code);
            } catch (AVException e) {
                return ResultGenerator.genFailResult(MValue.MESSAGE_SMS_CODE_ERROR);
            }
        } else {
            return employeeService.doLogin(mobile, code);
        }
    }

    /**
     * 获取个人信息
     *
     * @param token
     * @return
     */
    @PostMapping("/info")
    public Result info(@RequestParam String token) {
        if (!JWTUtil.verifyById(token, JWTUtil.getUserId(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        Employee employee = employeeService.getEmployeeById(JWTUtil.getUserId(token));

        return ResultGenerator.genSuccessResult(new InfoResponse(employee));
    }

    /**
     * 获取我的经纪人详细信息
     *
     * @param token
     * @param brokerId
     * @return
     */
    @PostMapping("/myBroker")
    public Result getMyBroker(@RequestParam String token,
                              @RequestParam String brokerId) {
        if (!JWTUtil.verifyById(token, JWTUtil.getUserId(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }
        return ResultGenerator.genSuccessResult(new MyBrokerResponse(employeeService.getMyBroker(brokerId)));
    }

    /**
     * 更新个人信息
     *
     * @param token
     * @param name
     * @param avatar
     * @param sex
     * @return
     */
    @PostMapping("/editInfo")
    public Result editInfo(@RequestParam String token,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String avatar,
                           @RequestParam(required = false) String sex) {
        if (!JWTUtil.verifyById(token, JWTUtil.getUserId(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        if (employeeService.updateEmployeeInfo(JWTUtil.getUserId(token), name, avatar, sex) > 0) {
            return ResultGenerator.genSuccessResult(new EmployeeResponse(employeeService.getEmployeeById(JWTUtil.getUserId(token))));
        }

        return ResultGenerator.genFailResult(MValue.MESSAGE_UPDATE_FAIL);

    }

    /**
     * 检查身份证认证信息
     *
     * @return
     */
    @PostMapping("/getInfo")
    public Result getInfo(@RequestParam String token) {

        if (!JWTUtil.verifyById(token, JWTUtil.getUserId(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        return ResultGenerator.genSuccessResult(new EmployeeResponse(employeeService.getEmployeeById(JWTUtil.getUserId(token))));

    }


//    @PostMapping("/initIDAuth")
//    public Result initIDAuth(@RequestParam String token) {
//
//        if (!JWTUtil.verifyById(token, JWTUtil.getUserId(token), CommonValue.SECRET)) {
//            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
//        }
//
//        Employee employee = employeeService.getEmployeeById(JWTUtil.getUserId(token));
//
//        if(employee.get)
//
//        return ResultGenerator.genSuccessResult(new EmployeeResponse(employeeService.getEmployeeById(JWTUtil.getUserId(token))));
//
//    }


    /**
     * 提交身份证认证
     *
     * @return
     */
    public Result submitIdCardAuth(@RequestParam String token,
                                   @RequestParam String idCardPicFace,
                                   @RequestParam String idCardPic) {
        if (!JWTUtil.verifyById(token, JWTUtil.getUserId(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        if (employeeService.updateEmployeeIdCardPic(JWTUtil.getUserId(token), idCardPicFace, idCardPic, AuthStatus.ING.code()) > 0) {
            return ResultGenerator.genSuccessResult(employeeService.getEmployeeById(JWTUtil.getUserId(token)));
        }

        return ResultGenerator.genFailResult(MValue.MESSAGE_UPDATE_FAIL);

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
                                  @RequestParam(defaultValue = "20") Integer limit, @RequestParam(required = false) String key) {

        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        PageHelper.startPage(page, limit);
        List<Employee> enterprises = null;

        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));
        if (adminUser.getRole() == ROLE.ROLE_ADMIN) {
            enterprises = employeeService.getEmployeeList(key);
        } else if (adminUser.getRole() == ROLE.ROLE_EDITOR) {
            enterprises = employeeService.getEmployeeListByParentID(adminUser.getId(), key);
        } else if (adminUser.getRole() == ROLE.ROLE_BROKER) {
            enterprises = employeeService.getEmployeeListByBrokerId(adminUser.getId(), key);
        }


        PageInfo<Employee> pageInfo = new PageInfo<>(enterprises);
        return ResultGenerator.genSuccessResult(new GetEmployeeListListResponse(page, limit, (int) pageInfo.getTotal(), pageInfo.getList()));
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
        return ResultGenerator.genSuccessResult(new GetEmployeeSignLogListListResponse(page, size, (int) pageInfo.getTotal(), pageInfo.getList()));
    }

}
