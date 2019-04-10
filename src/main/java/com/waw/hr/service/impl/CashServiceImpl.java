package com.waw.hr.service.impl;

import com.waw.hr.core.AbstractService;
import com.waw.hr.core.BalanceType;
import com.waw.hr.dao.CashMapper;
import com.waw.hr.dao.EmployeeMapper;
import com.waw.hr.dao.ShopMapper;
import com.waw.hr.entity.*;
import com.waw.hr.service.CashService;
import com.waw.hr.service.ShopService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CashServiceImpl extends AbstractService<CashLogModel> implements CashService {

    @Resource
    CashMapper cashMapper;

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<CashLogModel> cashList(int type) {
        return cashMapper.cashList(type == 2 ? true : null);
    }

    @Override
    public List<RecommendUser> recommendList(int type) {
        return cashMapper.recommendList(type == 1 ? true : null);
    }


    @Override
    public int addCashBalanceLog(int uid, String money) {
        return cashMapper.addCashBalanceLog(uid, money, BalanceType.CASH_MONEY.code(), "提现", String.valueOf(System.currentTimeMillis()));
    }

    @Override
    public int updateEmployeeCashLogStatus(int cashId) {
        return cashMapper.updateEmployeeCashLogStatus(cashId);
    }

    @Transactional
    @Override
    public int updateEmployeeBalanceByCash(Integer id, String balance, int cashId) {

        int balanceResult = employeeMapper.updateEmployeeBalance(id, balance);

        int cashResult = addCashBalanceLog(id, balance);

        int logResult = updateEmployeeCashLogStatus(cashId);

        if (balanceResult == 1 && cashResult == 1 && logResult == 1) {
            return 1;
        }

        return 0;
    }
}
