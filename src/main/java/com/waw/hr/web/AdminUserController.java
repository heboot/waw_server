package com.waw.hr.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waw.hr.CommonValue;
import com.waw.hr.core.*;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;
import com.waw.hr.response.*;
import com.waw.hr.service.AdminUserService;
import com.waw.hr.utils.JWTUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.waw.hr.core.ResultCode.UNAUTHORIZED;
import static com.waw.hr.core.ResultCode.USER_NOT_FOUND;

@RestController
@RequestMapping("/adminuser")
public class AdminUserController {

    @Resource
    private AdminUserService adminUserService;

    /**
     * 后台用户登录
     *
     * @return
     */
    @PostMapping("/doAdminUserLogin")
    public Result doAdminUserLogin(@RequestParam String username,
                                   @RequestParam String password) {
        AdminUser adminUser = adminUserService.getAdminUserByPassword(username, password);
        if (adminUser == null) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_USER_NOT_FOUND, USER_NOT_FOUND);
        }
        System.out.print("登录角色为" + adminUser.getRole());
        return ResultGenerator.genSuccessResult(new TokenResponse(JWTUtil.sign(username, adminUser.getRole(), CommonValue.SECRET)));
    }


    /**
     * 获取身份证审核列表
     *
     * @return
     */
    @PostMapping("/idCardList")
    public Result idCardList(@RequestParam String token, @RequestParam(defaultValue = "1") Integer sp,
                             @RequestParam(defaultValue = "20") Integer pageSize
    ) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }
        PageHelper.offsetPage(sp, pageSize);
        List<Employee> enterprises = adminUserService.getIdCardList();
        PageInfo<Employee> pageInfo = new PageInfo<>(enterprises);
        return ResultGenerator.genSuccessResult(new GetEmployeeListListResponse(sp, pageSize, (int) pageInfo.getPages(), pageInfo.getList(), (int) pageInfo.getTotal()));
    }


    @GetMapping("/getAdminUserInfo")
    public Result getAdminUserInfo(@RequestParam String token) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }
        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));
        ArrayList<String> arrayList = new ArrayList();
        if (adminUser.getRole() == 10) {//管理员
            arrayList.add(ROLE.ROLE_ADMIN_S);
//            arrayList.add(ROLE.ROLE_EDITOR_S);
//            arrayList.add(ROLE.ROLE_BROKER_S);
            adminUser.setRoles(arrayList);
        } else if (adminUser.getRole() == 5) {//
            arrayList.add(ROLE.ROLE_EDITOR_S);
//            arrayList.add(ROLE.ROLE_BROKER_S);
        } else if (adminUser.getRole() == 0) {
            arrayList.add(ROLE.ROLE_BROKER_S);
        }
        return ResultGenerator.genSuccessResult(adminUser);
    }

    /**
     * 添加管理员账户
     *
     * @param token
     * @param username
     * @param password
     * @param mobile
     * @return
     */
    @PostMapping("/addAdminUser")
    public Result addAdminUser(@RequestParam String token, @RequestParam String username, @RequestParam String password, @RequestParam String mobile, @RequestParam Integer role) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));

        if (adminUser.getRole() >= role) {
            Integer result = adminUserService.addAdminUser(username, password, mobile, role, adminUser.getId());
            if (result != null && result > 0) {
                return ResultGenerator.genSuccessResult(MValue.MESSAGE_CREATE_SUC);
            } else {
                return ResultGenerator.genFailResult(MValue.MESSAGE_CREATE_FAIL);
            }
        }
        return ResultGenerator.genFailResult(MValue.MESSAGE_ROLE_ERROR);
    }

    @PostMapping("/updateAdminUserStatus")
    public Result updateAdminUserStatus(@RequestParam String token, @RequestParam Integer uid, @RequestParam Integer status) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }

        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));
        Integer result = null;
        if (adminUser.getRole() == ROLE.ROLE_ADMIN) {
            result = adminUserService.updateAdminUserStatus(uid, status);
        } else if (adminUser.getRole() == ROLE.ROLE_EDITOR) {
            AdminUser updateUser = adminUserService.getAdminUserByID(uid);
            if (adminUser.getRole() > updateUser.getRole() && updateUser.getCreateUid() == adminUser.getId()) {
                result = adminUserService.updateAdminUserStatus(uid, status);
            } else {
                return ResultGenerator.genFailResult(MValue.MESSAGE_ROLE_ERROR);
            }
        }
        if (result != null && result > 0) {
            return ResultGenerator.genSuccessResult(MValue.MESSAGE_UPDATE_SUC);
        }

        return ResultGenerator.genFailResult(MValue.MESSAGE_ROLE_ERROR);
    }


    /**
     * 获取代理列表
     *
     * @param token
     * @return
     */
    @PostMapping("/getEditorList")
    public Result getEditorList(@RequestParam String token, @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "20") Integer limit, @RequestParam(required = false) String key) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }


        PageHelper.startPage(page, limit);
        List<AdminUser> adminUsers = null;

        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));
        if (adminUser.getRole() == ROLE.ROLE_ADMIN) {
            adminUsers = adminUserService.getEditorsList(null, key);
        } else if (adminUser.getRole() == ROLE.ROLE_EDITOR) {
            adminUsers = adminUserService.getEditorsList(adminUser.getId(), key);
        } else {
            return ResultGenerator.genFailResult(MValue.MESSAGE_ROLE_ERROR);
        }
        PageInfo<AdminUser> pageInfo = new PageInfo<>(adminUsers);
        return ResultGenerator.genSuccessResult(new GetAdminUserListListResponse(page, limit, (int) pageInfo.getTotal(), pageInfo.getList()));
    }


    /**
     * 获取代理列表
     *
     * @param token
     * @return
     */
    @PostMapping("/getBrokerList")
    public Result getBrokerList(@RequestParam String token, @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "20") Integer limit, @RequestParam(required = false) String key) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }


        PageHelper.startPage(page, limit);
        List<AdminUser> adminUsers = null;

        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));
        if (adminUser.getRole() == ROLE.ROLE_ADMIN) {
            adminUsers = adminUserService.getBrokerList(null, key);
        } else if (adminUser.getRole() == ROLE.ROLE_EDITOR) {
            adminUsers = adminUserService.getBrokerList(adminUser.getId(), key);
        } else {
            return ResultGenerator.genFailResult(MValue.MESSAGE_ROLE_ERROR);
        }
        PageInfo<AdminUser> pageInfo = new PageInfo<>(adminUsers);
        return ResultGenerator.genSuccessResult(new GetAdminUserListListResponse(page, limit, (int) pageInfo.getTotal(), pageInfo.getList()));
    }

    /**
     * 新增代理
     *
     * @param token
     * @return
     */
    @PostMapping("/addEditor")
    public Result addEditor(@RequestParam String token, @RequestParam String name, @RequestParam String mobile) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }
        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));
        if (adminUser.getRole() == ROLE.ROLE_ADMIN) {
            int result = adminUserService.addEditor(name, mobile, adminUser.getId());
            if (result > 0) {
                return ResultGenerator.genSuccessResult(MValue.MESSAGE_CREATE_SUC);
            } else {
                return ResultGenerator.genFailResult(MValue.MESSAGE_CREATE_FAIL);
            }
        }
        return ResultGenerator.genFailResult(MValue.MESSAGE_ROLE_ERROR);
    }

    /**
     * 新增经纪人
     *
     * @param token
     * @return
     */
    @PostMapping("/addBroker")
    public Result addBroker(@RequestParam String token, @RequestParam String name, @RequestParam String mobile) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult(MValue.MESSAGE_TOKEN_ERROR, UNAUTHORIZED);
        }
        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));
        if (adminUser.getRole() == ROLE.ROLE_ADMIN || adminUser.getRole() == ROLE.ROLE_EDITOR) {
            int result = adminUserService.addBroker(name, mobile, adminUser.getId());
            if (result > 0) {
                return ResultGenerator.genSuccessResult(MValue.MESSAGE_CREATE_SUC);
            } else {
                return ResultGenerator.genFailResult(MValue.MESSAGE_CREATE_FAIL);
            }
        }
        return ResultGenerator.genFailResult(MValue.MESSAGE_ROLE_ERROR);
    }



}
