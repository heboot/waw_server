package com.waw.hr.model;

import com.waw.hr.entity.Enterprise;

import javax.persistence.Transient;

public class JoinModel {

    private int id;

    private int uid;

    private int eid;

    private String joinTime;

    private int subsidyStatus;

    @Transient
    private Enterprise enterprise;

    @Transient
    private EmployeeModel employeeModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }

    public int getSubsidyStatus() {
        return subsidyStatus;
    }

    public void setSubsidyStatus(int subsidyStatus) {
        this.subsidyStatus = subsidyStatus;
    }
}
