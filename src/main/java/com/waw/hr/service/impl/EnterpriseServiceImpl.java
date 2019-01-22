package com.waw.hr.service.impl;

import com.waw.hr.core.AbstractService;
import com.waw.hr.dao.EnterpriseMapper;
import com.waw.hr.entity.Enterprise;
import com.waw.hr.service.EnterpriseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EnterpriseServiceImpl extends AbstractService<Enterprise> implements EnterpriseService {

    @Resource
    private EnterpriseMapper enterpriseMapper;


    @Override
    public List<Enterprise> getAllEnterprise() {
        return enterpriseMapper.getAllEnterprise();
    }

    @Override
    public List<Enterprise> getEnterpriseByName(String name) {
        return enterpriseMapper.getEnterpriseByName(name);
    }

    @Override
    public Integer removeEnterprise(Integer id) {
        return enterpriseMapper.removeEnterprise(id);
    }

    @Override
    public Enterprise getEnterpriseById(Integer id) {
        return enterpriseMapper.getEnterpriseById(id);
    }

    @Override
    public Integer updateEnterprise(Enterprise enterprise) {
        return enterpriseMapper.updateEnterprise(enterprise);
    }

    @Override
    public Integer addEnterprise(Enterprise enterprise) {
        return enterpriseMapper.addEnterprise(enterprise);
    }


}
