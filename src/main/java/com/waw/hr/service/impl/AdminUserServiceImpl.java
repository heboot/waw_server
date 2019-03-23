package com.waw.hr.service.impl;

import com.waw.hr.core.AbstractService;
import com.waw.hr.dao.AdminUserMapper;
import com.waw.hr.dao.EmployeeMapper;
import com.waw.hr.dao.EnterpriseMapper;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;
import com.waw.hr.entity.EmployeeBank;
import com.waw.hr.entity.Enterprise;
import com.waw.hr.service.AdminUserService;
import com.waw.hr.service.EnterpriseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AdminUserServiceImpl extends AbstractService<AdminUser> implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public AdminUser getAdminUserByPassword(String name, String pwd) {
        return adminUserMapper.getAdminUserByPassword(name, pwd);
    }

    @Override
    public AdminUser getAdminUserByName(String name) {
        return adminUserMapper.getAdminUserByName(name);
    }

    @Override
    public AdminUser getAdminUserByID(Integer id) {
        return adminUserMapper.getAdminUserByID(id);
    }

    @Override
    public Integer addAdminUser(String name, String password, String mobile, int role, int uid) {
        return adminUserMapper.addAdminUser(name, password, mobile, role, uid);
    }

    @Override
    public Integer updateAdminUserStatus(Integer uid, Integer status) {
        return adminUserMapper.updateAdminUserStatus(uid, status);
    }

    /**
     * 获取属于自己的代理列表
     *
     * @param createId
     * @return
     */
    @Override
    public List<AdminUser> getEditorsList(Integer createId, String key) {
        return adminUserMapper.getEditorsList(createId, key);
    }

    @Override
    public List<AdminUser> getBrokerList(Integer createId, String key) {
        return adminUserMapper.getBrokerList(createId, key);
    }

    @Override
    public Integer addEditor(String name, String mobile, Integer createId) {
        return adminUserMapper.addEditor(name, mobile, createId, String.valueOf(System.currentTimeMillis()), 5);
    }


    @Override
    public Integer addBroker(String name, String mobile, Integer createId) {
        return adminUserMapper.addEditor(name, mobile, createId, String.valueOf(System.currentTimeMillis()), 1);
    }

    @Override
    public List<EmployeeBank> bankList() {
        return null;
    }

    @Override
    public List<Employee> getIdCardList() {
        return employeeMapper.getIdCardList();
    }
}
