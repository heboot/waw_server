package com.waw.hr.service;

import com.waw.hr.entity.Enterprise;

import java.util.List;

public interface EnterpriseService {

    List<Enterprise> getEnterpriseList(String key, Integer sort);

    List<Enterprise> getEnterpriseByName(String name);

    Integer removeEnterprise(Integer id);

    Enterprise getEnterpriseById(Integer id);

    Integer updateEnterprise(Enterprise enterprise);

    Integer addEnterprise(Enterprise enterprise);

    Integer updateEnterpriseSubsidy(Integer id, Integer money, String info);

    Integer followEnterprise(String uid, String enterpriseId, int type);

    List<Enterprise> getMyEnterpriseList(String uid);

}
