package com.waw.hr.service;

import com.waw.hr.entity.Enterprise;

import java.util.List;

public interface EnterpriseService {

    List<Enterprise> getAllEnterprise();

    List<Enterprise> getEnterpriseByName(String name);

    Integer removeEnterprise(Integer id);

    Enterprise getEnterpriseById(Integer id);

    Integer updateEnterprise(Enterprise enterprise);

    Integer addEnterprise(Enterprise enterprise);

    Integer updateEnterpriseSubsidy(Integer id, Integer money, String info);

}
