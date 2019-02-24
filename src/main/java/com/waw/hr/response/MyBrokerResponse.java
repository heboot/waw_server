package com.waw.hr.response;

import com.waw.hr.entity.AdminUser;

public class MyBrokerResponse {

    private AdminUser broker;

    public AdminUser getBroker() {
        return broker;
    }

    public void setBroker(AdminUser broker) {
        this.broker = broker;
    }

    public MyBrokerResponse(AdminUser broker) {
        this.broker = broker;
    }
}
