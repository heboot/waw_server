package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserMapper extends Mapper<AdminUser> {

    AdminUser getAdminUserByPassword(String name, String pwd);

    AdminUser getAdminUserByName(String name);
}
