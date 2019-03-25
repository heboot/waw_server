package com.waw.hr.response;

import com.waw.hr.entity.EmployeeBank;

public class BankInfoResponse {

    private EmployeeBank bankInfo;

    public EmployeeBank getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(EmployeeBank bankInfo) {
        this.bankInfo = bankInfo;
    }

    public BankInfoResponse(EmployeeBank bankInfo) {
        this.bankInfo = bankInfo;
    }
}
