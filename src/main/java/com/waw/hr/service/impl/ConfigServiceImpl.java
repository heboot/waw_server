package com.waw.hr.service.impl;

import com.waw.hr.core.AbstractService;
import com.waw.hr.dao.ConfigDataMapper;
import com.waw.hr.entity.BankModel;
import com.waw.hr.service.ConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ConfigServiceImpl extends AbstractService<BankModel> implements ConfigService {

    @Resource
    private ConfigDataMapper configDataMapper;


    @Override
    public List<BankModel> bankList() {
        return configDataMapper.bankList();
    }

}
