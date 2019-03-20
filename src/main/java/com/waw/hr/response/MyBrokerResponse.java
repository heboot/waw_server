package com.waw.hr.response;

import com.waw.hr.model.AdminUserModel;

public class MyBrokerResponse {

    private AdminUserModel broker;

    public AdminUserModel getBroker() {
        return broker;
    }

    public void setBroker(AdminUserModel broker) {
        this.broker = broker;
    }

    public MyBrokerResponse(AdminUserModel broker) {
        this.broker = broker;
    }
}
