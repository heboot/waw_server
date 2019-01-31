package com.waw.hr.entity;

import javax.persistence.Table;

@Table(name = "tb_emplpyee")
public class Employee {

    private Integer id;

    private String name;

    private String mobile;

    private String createTime;

    private Integer brokerId;

    private String joinWorkTime;

    private int sex;

    private int age;

    private String idCardPicFace;

    private String idCardPic;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public String getJoinWorkTime() {
        return joinWorkTime;
    }

    public void setJoinWorkTime(String joinWorkTime) {
        this.joinWorkTime = joinWorkTime;
    }

    public String getIdCardPicFace() {
        return idCardPicFace;
    }

    public void setIdCardPicFace(String idCardPicFace) {
        this.idCardPicFace = idCardPicFace;
    }

    public String getIdCardPic() {
        return idCardPic;
    }

    public void setIdCardPic(String idCardPic) {
        this.idCardPic = idCardPic;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
