package com.waw.hr.response;

import com.waw.hr.entity.Employee;

public class LoginResponse extends TokenResponse {

    private Employee user;

    public LoginResponse(String token, Employee user) {
        super(token);
        this.user = user;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }
}
