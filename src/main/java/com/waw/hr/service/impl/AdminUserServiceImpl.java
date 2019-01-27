package com.waw.hr.service.impl;

import com.waw.hr.core.AbstractService;
import com.waw.hr.dao.AdminUserMapper;
import com.waw.hr.dao.EnterpriseMapper;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Enterprise;
import com.waw.hr.service.AdminUserService;
import com.waw.hr.service.EnterpriseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminUserServiceImpl extends AbstractService<AdminUser> implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;


    @Override
    public AdminUser getAdminUserByPassword(String name, String pwd) {
        return adminUserMapper.getAdminUserByPassword(name, pwd);
    }

    @Override
    public AdminUser getAdminUserByName(String name) {
        return adminUserMapper.getAdminUserByName(name);
    }
}
