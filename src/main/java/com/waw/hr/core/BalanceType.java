package com.waw.hr.core;

public enum BalanceType {

    JOIN_SUBSIDY(0),//入职厂商补贴
    RECOMMEND_MONEY(1),//推荐奖金
    CASH_MONEY(-1);//提现到银行卡


    private final int code;

    BalanceType(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
