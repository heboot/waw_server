package com.waw.hr.entity;

public class EnterpriseListModel {
    //主键
    private Integer id;

    //企业名称
    private String name;

    //综合薪资 比如3000-4500元
    private String salary;

    //企业补贴金额
    private Integer subsidyMoney;

    public Integer getSubsidyMoney() {
        return subsidyMoney;
    }

    public void setSubsidyMoney(Integer subsidyMoney) {
        this.subsidyMoney = subsidyMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}