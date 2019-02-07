package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserMapper extends Mapper<AdminUser> {

    AdminUser getAdminUserByPassword(String name, String pwd);

    AdminUser getAdminUserByName(String name);

    AdminUser getAdminUserByID(Integer id);

    Integer updateAdminUserStatus(@Param("uid") Integer uid, @Param("status") Integer status);

//    List<Enterprise> getEnterpriseByName(@Param("name") String name);


    Integer addAdminUser(@Param("name") String name, @Param("password") String password, @Param("mobile") String mobile, @Param("role") Integer role, @Param("uid") Integer uid);

    /**
     * 获取属于自己的代理列表
     *
     * @param createId
     * @return
     */
    List<AdminUser> getEditorsList(@Param("createUid") Integer createId, @Param("key") String key);

    /**
     * 创建代理
     *
     * @param createId
     * @return
     */
    Integer addEditor(@Param("name") String name,@Param("mobile") String mobile,@Param("createUid") Integer createId,@Param("createTime") String createTime);
}
