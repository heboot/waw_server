package com.waw.hr.entity;

import javax.persistence.Table;

@Table(name = "tb_emplpyee_sign_log")
public class EmployeeSignLog {

    private Integer id;

    private Integer employeeId;

    private String signTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }
}
