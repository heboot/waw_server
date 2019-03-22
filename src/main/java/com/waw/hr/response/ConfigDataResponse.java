package com.waw.hr.response;

import com.waw.hr.entity.BankModel;

import java.util.List;

public class ConfigDataResponse extends BaseResponse {

    //客服电话
    private String kfTel;

    private List<BankModel> bankList;

    private String version;


    public String getKfTel() {
        return kfTel;
    }

    public void setKfTel(String kfTel) {
        this.kfTel = kfTel;
    }

    public List<BankModel> getBankList() {
        return bankList;
    }

    public void setBankList(List<BankModel> bankList) {
        this.bankList = bankList;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ConfigDataResponse(String kfTel, List<BankModel> bankList, String version) {
        this.kfTel = kfTel;
        this.bankList = bankList;
        this.version = version;
    }
}
