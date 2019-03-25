package com.waw.hr.entity;

import com.waw.hr.core.MValue;
import com.waw.hr.model.EmployeeModel;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "tb_employee_bank")
public class EmployeeBank {

    private int id;

    private int uid;

    private int bankId;

    private String bankNumber;

    private String picFront;

    private String picReverse;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //本地字段
    @Transient
    private EmployeeModel employeeModel;

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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getPicFront() {
        if (StringUtils.isEmpty(picFront)) {
            return picFront;
        }
        return MValue.IMAGE_PRIFIX + picFront;
    }

    public void setPicFront(String picFront) {
        this.picFront = picFront;
    }

    public String getPicReverse() {
        if (StringUtils.isEmpty(picReverse)) {
            return picReverse;
        }
        return MValue.IMAGE_PRIFIX + picReverse;
    }

    public void setPicReverse(String picReverse) {
        this.picReverse = picReverse;
    }
}
