package com.waw.hr.response;

import com.waw.hr.core.MValue;
import com.waw.hr.entity.BankModel;

import java.util.List;

public class ConfigDataResponse extends BaseResponse {

    //客服电话
    private String kfTel;

    private List<BankModel> bankList;

    private String version;

    private String recommendInfo;

    private String recommendIcon;

    private String cashTip;

    public String getCashTip() {
        return cashTip;
    }

    public void setCashTip(String cashTip) {
        this.cashTip = cashTip;
    }

    public String getRecommendIcon() {
        return MValue.IMAGE_PRIFIX + recommendIcon;
    }

    public void setRecommendIcon(String recommendIcon) {
        this.recommendIcon = recommendIcon;
    }

    public String getRecommendInfo() {
        return recommendInfo;
    }

    public void setRecommendInfo(String recommendInfo) {
        this.recommendInfo = recommendInfo;
    }

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

    public ConfigDataResponse() {
    }
}
