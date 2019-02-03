package com.waw.hr.core;

public enum JobStatus {

    BASIC(0),//报名，但是还没进厂工作
    ING(1),//已进厂工作
    OUT(2);//离职


    private final int code;

    JobStatus(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
