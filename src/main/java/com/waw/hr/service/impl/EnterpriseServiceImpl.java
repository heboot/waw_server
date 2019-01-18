package com.waw.hr.service.impl;

import com.waw.hr.core.AbstractService;
import com.waw.hr.service.EnterpriseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class EnterpriseServiceImpl extends AbstractService<EnterpriseService> implements EnterpriseService  {

    @Resource
    private EnterpriseService enterpriseService;



}
