package com.waw.hr.service;

import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;
import com.waw.hr.entity.EmployeeBank;

import java.util.List;

public interface AdminUserService {

    AdminUser getAdminUserByPassword(String name, String pwd);

    AdminUser getAdminUserByName(String name);

    AdminUser getAdminUserByID(Integer id);

    Integer addAdminUser(String name, String password, String mobile, int role, int uid);

    Integer updateAdminUserStatus(Integer uid, Integer status);


    /**
     * 获取属于自己的代理列表
     *
     * @param createId
     * @return
     */
    List<AdminUser> getEditorsList(Integer createId, String key);

    /**
     * 获取属于自己的经纪人列表
     *
     * @param createId
     * @return
     */
    List<AdminUser> getBrokerList(Integer createId, String key);

    /**
     * 创建代理
     *
     * @param createId
     * @return
     */
    Integer addEditor(String name, String mobile, Integer createId);

    /**
     * 创建经纪人
     *
     * @param createId
     * @return
     */
    Integer addBroker(String name, String mobile, Integer createId);


    List<EmployeeBank> bankList();


    /**
     * 获取有身份证信息的员工列表
     *
     * @return
     */
    List<Employee> getIdCardList();


    /**
     * 发放入职补贴
     *
     * @param employeeId
     * @param money
     * @return
     */
    Integer sendEmployeeJoinSubsidyMoney(String employeeId, String money);




}
