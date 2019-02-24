package com.waw.hr.response;

import com.waw.hr.entity.Employee;

public class InitAuthByIDCardResponse {

    private int status;

    private Employee user;

    public InitAuthByIDCardResponse(int status, Employee user) {
        this.status = status;
        this.user = user;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
