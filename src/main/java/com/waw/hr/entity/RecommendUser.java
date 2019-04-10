package com.waw.hr.entity;

import com.waw.hr.model.EmployeeModel;
import com.waw.hr.utils.DateUtil;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "tb_recommend")
public class RecommendUser {

    private int id;

    private String name;

    private String mobile;

    private int uid;

    private String createTime;

    private int moneyStatus;

    @Transient
    private Integer joinStatus = 0;

    @Transient
    private String joinTime;

    @Transient
    private int joinDays;

    @Transient
    private EmployeeModel employeeModel;

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public int getJoinDays() {
        if (joinTime != null) {
            return DateUtil.countDays(new Date(Long.parseLong(joinTime)));
        }
        return joinDays;
    }

    public void setJoinDays(Integer joinDays) {
        this.joinDays = joinDays;
    }

    public Integer getJoinStatus() {
        return joinStatus;
    }

    public void setJoinStatus(Integer joinStatus) {
        this.joinStatus = joinStatus;
    }

    public void setJoinDays(int joinDays) {
        this.joinDays = joinDays;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getMoneyStatus() {
        return moneyStatus;
    }

    public void setMoneyStatus(int moneyStatus) {
        this.moneyStatus = moneyStatus;
    }
}
