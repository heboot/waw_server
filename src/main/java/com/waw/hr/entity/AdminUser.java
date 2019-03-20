package com.waw.hr.entity;

import com.waw.hr.model.AdminUserModel;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Table(name = "tb_enterprise")
public class AdminUser extends AdminUserModel {
    private String passWord;

    @Transient
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
