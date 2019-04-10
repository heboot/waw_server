package com.waw.hr.entity;

import com.waw.hr.model.EmployeeModel;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "tb_cash_log")
public class CashLogModel {

    private int id;

    private String uid;

    private String money;

    private int status;

    private String updateTime;

    private String createTime;

    @Transient
    private EmployeeModel employeeModel;

    @Transient
    private EmployeeBank bankModel;

    public EmployeeBank getBankModel() {
        return bankModel;
    }

    public void setBankModel(EmployeeBank bankModel) {
        this.bankModel = bankModel;
    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
