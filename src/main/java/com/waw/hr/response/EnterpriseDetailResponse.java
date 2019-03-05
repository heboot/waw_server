package com.waw.hr.response;

import com.waw.hr.entity.Enterprise;

public class EnterpriseDetailResponse {

    private Enterprise enterprise;

    public EnterpriseDetailResponse(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
