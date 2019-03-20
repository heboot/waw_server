package com.waw.hr.response;

import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;
import com.waw.hr.model.EmployeeModel;

public class LoginResponse extends TokenResponse {

    private EmployeeModel user;

//    private AdminUser adminUser;
//
//    public AdminUser getAdminUser() {
//        return adminUser;
//    }
//
//    public void setAdminUser(AdminUser adminUser) {
//        this.adminUser = adminUser;
//    }

    public LoginResponse(String token, EmployeeModel user) {
        super(token);
        this.user = user;
    }

//    public LoginResponse(String token, AdminUser user) {
//        super(token);
//        this.adminUser = user;
//    }

    public EmployeeModel getUser() {
        return user;
    }

    public void setUser(EmployeeModel user) {
        this.user = user;
    }
}
