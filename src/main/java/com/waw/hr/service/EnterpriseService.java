package com.waw.hr.service;

import com.waw.hr.entity.Enterprise;

import java.util.List;

public interface EnterpriseService {

    List<Enterprise> getAllEnterprise();

    int updateEnterpriseById(Enterprise enterprise);

    int addEnterprise(Enterprise enterprise);

}
