package com.waw.hr.web;

import com.waw.hr.CommonValue;
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
            return ResultGenerator.genFailResult("用户不存在", USER_NOT_FOUND);
        }
        return ResultGenerator.genSuccessResult(new BaseResponse(JWTUtil.sign(username, CommonValue.SECRET)));
    }


    @GetMapping("/getAdminUserInfo")
    public Result getAdminUserInfo(@RequestParam String token) {
        if (!JWTUtil.verify(token, JWTUtil.getUsername(token), CommonValue.SECRET)) {
            return ResultGenerator.genFailResult("token error", UNAUTHORIZED);
        }
        AdminUser adminUser = adminUserService.getAdminUserByName(JWTUtil.getUsername(token));
        ArrayList arrayList = new ArrayList();
        if (adminUser.getRole() == 10) {//管理员
            arrayList.add("admin");
            arrayList.add("editor");
            arrayList.add("daili");
            adminUser.setRoles(arrayList);
        } else if (adminUser.getRole() == 5) {//

        }
        return ResultGenerator.genSuccessResult(adminUser);
    }


}
