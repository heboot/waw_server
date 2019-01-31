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

    private Integer create_uid;

    @Transient
    private List<String> roles;

    public Integer getCreate_uid() {
        return create_uid;
    }

    public void setCreate_uid(Integer create_uid) {
        this.create_uid = create_uid;
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
}
