package com.waw.hr.response;

import com.waw.hr.entity.Employee;

public class InfoResponse {

    private Employee user;

    public InfoResponse(Employee user) {
        this.user = user;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }
}
