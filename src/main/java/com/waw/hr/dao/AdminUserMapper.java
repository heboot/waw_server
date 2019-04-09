package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;
import com.waw.hr.entity.EmployeeBank;
import com.waw.hr.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserMapper extends Mapper<AdminUser> {

    AdminUser getAdminUserByPassword(@Param("name") String name, @Param("pwd") String pwd);

    AdminUser getAdminUserByName(String name);

    AdminUser getAdminUserByID(Integer id);

    AdminUser getAdminUserByMobile(@Param("mobile") String mobile);

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
    Integer addEditor(@Param("name") String name, @Param("mobile") String mobile, @Param("createUid") Integer createId, @Param("createTime") String createTime, @Param("role") int role);

    /**
     * 获取属于自己的经纪人列表
     *
     * @param createId
     * @return
     */
    List<AdminUser> getBrokerList(@Param("createUid") Integer createId, @Param("key") String key);


    /**
     * 创建经纪人
     *
     * @param createId
     * @return
     */
    Integer addBroker(@Param("name") String name, @Param("mobile") String mobile, @Param("createUid") Integer createId);


    /**
     * 获取银行卡列表
     *
     * @return
     */
    List<EmployeeBank> bankList();

    /**
     * 发放入职补贴
     *
     * @param employeeId
     * @param money
     * @return
     */
    Integer sendEmployeeJoinSubsidyMoney(@Param("id") String employeeId, @Param("money") String money, @Param("type") int type, @Param("remark") String remark, @Param("time") String time);


}
