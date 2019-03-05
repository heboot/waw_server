package com.waw.hr.response;

import com.waw.hr.entity.Employee;

public class AuthResponse {

    private String errorMessage;

    private Employee user;

    public AuthResponse(String errorMessage, Employee user) {
        this.errorMessage = errorMessage;
        this.user = user;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
