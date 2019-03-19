package com.waw.hr.model;

import com.waw.hr.entity.Banner;
import com.waw.hr.entity.EnterpriseTag;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnterpriseListModel {
    //主键
    private Integer id;

    //企业名称
    private String name;

    //综合薪资 比如3000-4500元
    private String salary;

    //企业补贴金额
    private Integer subsidyMoney;

    //本地字段
    @Transient
    private List<EnterpriseTag> tags;


    public List<EnterpriseTag> getTags() {
        tags = new ArrayList<>();
        tags.add(new EnterpriseTag(1001, "周边热闹"));
        tags.add(new EnterpriseTag(1002, "妹子多"));
        if (id % 2 == 0) {
            tags.add(new EnterpriseTag(1003, "周边热闹"));
        } else {
            tags.add(new EnterpriseTag(1004, "食宿好"));
        }

        return tags;
    }

    public void setTags(List<EnterpriseTag> tags) {
        this.tags = tags;
    }

    private int pnumber;

    public int getPnumber() {
        return new Random().nextInt(9) + 1;
    }

    public void setPnumber(int pnumber) {
        this.pnumber = pnumber;
    }

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
