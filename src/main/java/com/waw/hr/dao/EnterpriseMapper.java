package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnterpriseMapper extends Mapper<Enterprise> {

    List<Enterprise> getEnterpriseList(@Param("key") String key, @Param("sort") Integer sort);

    List<Enterprise> getEnterpriseByName(@Param("name") String name);

    Enterprise getEnterpriseById(@Param("id") Integer id);

    Integer updateEnterprise(Enterprise enterprise);

    Integer addEnterprise(Enterprise enterprise);

    Integer removeEnterprise(@Param("id") Integer id);

    Integer updateEnterpriseSubsidy(@Param("id") Integer id, @Param("money") Integer money, @Param("info") String info);

    //关注
    Integer followEnterprise(@Param("uid") String uid, @Param("enterpriseId") String enterpriseId);

    Integer unfollowEnterprise(@Param("uid") String uid, @Param("enterpriseId") String enterpriseId);

    List<Enterprise> getMyEnterpriseList(@Param("uid") String uid);
}
