package com.waw.hr.service;

import com.waw.hr.entity.Enterprise;
import com.waw.hr.entity.EnterpriseListModel;

import java.util.List;

public interface EnterpriseService {

    List<Enterprise> getEnterpriseList(String key, Integer sort);

    List<EnterpriseListModel> enterpriseList(String key, Integer sort);

    List<Enterprise> getEnterpriseByName(String name);

    Integer removeEnterprise(Integer id);

    Enterprise getEnterpriseById(String id);

    Integer updateEnterprise(Enterprise enterprise);

    Integer addEnterprise(Enterprise enterprise);

    Integer updateEnterpriseSubsidy(String id, Integer money, String info);

    Integer followEnterprise(String uid, String enterpriseId, int type);

    Integer join(String uid, String enterpriseId, String time);

    Integer is_follow(String uid, String enterpriseId);

    Integer is_join(String uid, String enterpriseId);

    List<Enterprise> getMyEnterpriseList(String uid);




}
