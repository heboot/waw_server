package com.waw.hr.response;

import com.waw.hr.entity.Employee;

public class EmployeeResponse {

    private Employee user;

    public EmployeeResponse(Employee user) {
        this.user = user;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

}
