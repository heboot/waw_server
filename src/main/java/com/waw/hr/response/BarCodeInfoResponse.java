package com.waw.hr.response;

import com.waw.hr.model.BarCodeInfo;

public class BarCodeInfoResponse {

    private BarCodeInfo info;

    public BarCodeInfo getInfo() {
        return info;
    }

    public void setInfo(BarCodeInfo info) {
        this.info = info;
    }

    public BarCodeInfoResponse(BarCodeInfo info) {
        this.info = info;
    }
}
