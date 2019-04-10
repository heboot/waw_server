package com.waw.hr.service;

import com.waw.hr.entity.CashLogModel;
import com.waw.hr.entity.RecommendUser;

import java.util.List;

public interface CashService {

    /**
     * 获取系统里的申请提现记录
     * <p>
     * type != 2 就是未打款  == 2 已打款
     *
     * @return
     */
    List<CashLogModel> cashList(int type);

    List<RecommendUser> recommendList(int type);


    //新增一条提现的余额明细
    int addCashBalanceLog(int uid, String money);

    //把某条记录更新为已打款
    int updateEmployeeCashLogStatus(int cashId);


    int updateEmployeeBalanceByCash(Integer id, String balance, int cashId);
}
