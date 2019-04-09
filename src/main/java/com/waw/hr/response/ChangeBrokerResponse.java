package com.waw.hr.response;

import com.waw.hr.model.AdminUserModel;

public class ChangeBrokerResponse {

    private AdminUserModel broker;

    public AdminUserModel getBroker() {
        return broker;
    }

    public void setBroker(AdminUserModel broker) {
        this.broker = broker;
    }

    public ChangeBrokerResponse(AdminUserModel broker) {
        this.broker = broker;
    }
}
