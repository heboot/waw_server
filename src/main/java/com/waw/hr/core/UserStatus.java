package com.waw.hr.core;

public enum UserStatus {

    BASIC(1),//正常
    STOP(-1);//禁用


    private final int code;

    UserStatus(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
    }
