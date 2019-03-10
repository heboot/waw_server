package com.waw.hr.entity;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Table(name = "tb_enterprise")
public class AdminUser {

    private Integer id;

    private String name;

    private String passWord;

    private String mobile;

    private Integer status;

    private int role;

    private Integer createUid;

    private String createTime;

    private String lastLoginTime;

    private String wx_code;

    private String qq_code;


    @Transient
    private List<String> roles;


    public Integer getCreateUid() {
        return createUid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWx_code() {
        return wx_code;
    }

    public void setWx_code(String wx_code) {
        this.wx_code = wx_code;
    }

    public String getQq_code() {
        return qq_code;
    }

    public void setQq_code(String qq_code) {
        this.qq_code = qq_code;
    }
}
