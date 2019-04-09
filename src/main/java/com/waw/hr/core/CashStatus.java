package com.waw.hr.core;

public enum CashStatus {

    BASIC(0),//不可提现
    CAN(1),//可提现
    CASH_ED(2);//已经提现


    private final int code;

    CashStatus(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
