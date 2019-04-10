package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.CashLogModel;
import com.waw.hr.entity.CityEntity;
import com.waw.hr.entity.RecommendUser;
import com.waw.hr.entity.ShopEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CashMapper extends Mapper<CashLogModel> {

    List<CashLogModel> cashList(@Param("cashed") Boolean cashed);


    List<RecommendUser> recommendList(@Param("cashed") Boolean cashed);

    //新增一条余额明细
    int addCashBalanceLog(@Param("uid") int uid, @Param("money") String money, @Param("type") int type, @Param("remark") String remark, @Param("createTime") String createTime);

    //把某条记录更新为已打款
    int updateEmployeeCashLogStatus(@Param("cashId") int cashId);
}
