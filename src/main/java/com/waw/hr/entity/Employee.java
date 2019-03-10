package com.waw.hr.entity;

import com.waw.hr.core.MValue;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "tb_emplpyee")
public class Employee {

    private Integer id;

    private String name;

    private String avatar;

    private String mobile;

    private String createTime;

    private Integer brokerId;

    private Integer parentId;

    private String joinWorkTime;

    private int sex;

    private int age;

    private String idCardPicFace;

    private String idCardPic;

    private String bankCardFront;

    private String bankCardReverse;

    private int status;

    private int jobStatus;

    private int cashStatus;

    private int idCardStatus;

    private int bankCardStatus;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Transient
    private AdminUser parentUser;

    @Transient
    private AdminUser brokerUser;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = MValue.IMAGE_PRIFIX + avatar;
    }

    public String getBankCardFront() {
        return bankCardFront;
    }

    public void setBankCardFront(String bankCardFront) {
        this.bankCardFront = bankCardFront;
    }

    public String getBankCardReverse() {
        return bankCardReverse;
    }

    public void setBankCardReverse(String bankCardReverse) {
        this.bankCardReverse = bankCardReverse;
    }

    public int getIdCardStatus() {
        return idCardStatus;
    }

    public void setIdCardStatus(int idCardStatus) {
        this.idCardStatus = idCardStatus;
    }

    public int getBankCardStatus() {
        return bankCardStatus;
    }

    public void setBankCardStatus(int bankCardStatus) {
        this.bankCardStatus = bankCardStatus;
    }

    public AdminUser getParentUser() {
        return parentUser;
    }

    public void setParentUser(AdminUser parentUser) {
        this.parentUser = parentUser;
    }

    public AdminUser getBrokerUser() {
        return brokerUser;
    }

    public void setBrokerUser(AdminUser brokerUser) {
        this.brokerUser = brokerUser;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }

    public int getCashStatus() {
        return cashStatus;
    }

    public void setCashStatus(int cashStatus) {
        this.cashStatus = cashStatus;
    }

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
