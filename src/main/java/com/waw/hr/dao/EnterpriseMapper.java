package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.Enterprise;

import java.util.List;

public interface EnterpriseMapper extends Mapper<Enterprise> {

    List<Enterprise> getEnterpriseList();

    Enterprise getEnterpriseInfoById(Integer id);

    Enterprise getEnterpriseInfoByName(String name);


}
