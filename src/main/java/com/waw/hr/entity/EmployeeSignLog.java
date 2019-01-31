package com.waw.hr.entity;

import javax.persistence.Table;

@Table(name = "tb_emplpyee_sign_log")
public class EmployeeSignLog {

    private Integer id;

    private Integer employee_id;

    private String sign_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getSign_time() {
        return sign_time;
    }

    public void setSign_time(String sign_time) {
        this.sign_time = sign_time;
    }
}
