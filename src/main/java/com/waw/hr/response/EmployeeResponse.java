package com.waw.hr.response;

import com.waw.hr.entity.Employee;
import com.waw.hr.model.EmployeeModel;

public class EmployeeResponse {

    private EmployeeModel user;

    public EmployeeResponse(EmployeeModel user) {
        this.user = user;
    }

    public EmployeeModel getUser() {
        return user;
    }

    public void setUser(EmployeeModel user) {
        this.user = user;
    }

}
