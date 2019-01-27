package com.waw.hr.service;

import com.waw.hr.entity.AdminUser;

public interface AdminUserService {

    AdminUser getAdminUserByPassword(String name, String pwd);

    AdminUser getAdminUserByName(String name);

}
