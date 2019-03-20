package com.waw.hr.response;

import com.waw.hr.entity.Employee;
import com.waw.hr.model.EmployeeModel;

public class InfoResponse {

    private EmployeeModel user;

    public InfoResponse(EmployeeModel user) {
        this.user = user;
    }

    public EmployeeModel getUser() {
        return user;
    }

    public void setUser(EmployeeModel user) {
        this.user = user;
    }
}
