package com.waw.hr.response;

import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;

public class LoginResponse extends TokenResponse {

    private Employee user;

//    private AdminUser adminUser;
//
//    public AdminUser getAdminUser() {
//        return adminUser;
//    }
//
//    public void setAdminUser(AdminUser adminUser) {
//        this.adminUser = adminUser;
//    }

    public LoginResponse(String token, Employee user) {
        super(token);
        this.user = user;
    }

//    public LoginResponse(String token, AdminUser user) {
//        super(token);
//        this.adminUser = user;
//    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }
}
