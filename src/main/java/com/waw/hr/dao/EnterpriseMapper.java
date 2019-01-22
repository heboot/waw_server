package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnterpriseMapper extends Mapper<Enterprise> {

    List<Enterprise> getAllEnterprise();

    Enterprise getEnterpriseById(@Param("id") Integer id);

    Enterprise getEnterpriseByName(@Param("name") String name);

    Integer updateEnterprise(Enterprise enterprise);

    Integer addEnterprise(Enterprise enterprise);

}
