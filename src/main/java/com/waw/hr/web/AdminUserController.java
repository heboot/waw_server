package com.waw.hr.web;

import com.waw.hr.CommonValue;
import com.waw.hr.core.MValue;
import com.waw.hr.core.ROLE;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.dao.AdminUserMapper;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.response.BaseResponse;
import com.waw.hr.service.AdminUserService;
import com.waw.hr.utils.JWTUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.ArrayList;

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
        return ResultGenerator.genSuccessResult(new BaseResponse(JWTUtil.sign(username, CommonValue.SECRET)));
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
            arrayList.add(ROLE.ROLE_EDITOR_S);
            arrayList.add(ROLE.ROLE_BROKER_S);
            adminUser.setRoles(arrayList);
        } else if (adminUser.getRole() == 5) {//
            arrayList.add(ROLE.ROLE_EDITOR_S);
            arrayList.add(ROLE.ROLE_BROKER_S);
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
    @PostMapping
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

    @PostMapping
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
            if (adminUser.getRole() > updateUser.getRole() && updateUser.getCreate_uid() == adminUser.getId()) {
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


}
