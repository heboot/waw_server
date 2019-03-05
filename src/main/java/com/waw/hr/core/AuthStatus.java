package com.waw.hr.core;

public enum AuthStatus {

    BASIC(0),//无提交 没有认证过
    ING(1),//认证中
    SUC(2),//认证成功
    FAIL(-1);//认证失败


    private final int code;

    AuthStatus(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
