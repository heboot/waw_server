package com.waw.hr.service;

import com.waw.hr.entity.AdminUser;

public interface AdminUserService {

    AdminUser getAdminUserByPassword(String name, String pwd);

    AdminUser getAdminUserByName(String name);

    AdminUser getAdminUserByID(Integer id);

    Integer addAdminUser(String name, String password, String mobile, int role, int uid);

    Integer updateAdminUserStatus(Integer uid, Integer status);

}
