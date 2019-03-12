package com.waw.hr.response;

public class FollowResponse {
    public FollowResponse(int is_follow) {
        this.is_follow = is_follow;
    }

    private int is_follow;

    public int getIs_follow() {
        return is_follow;
    }

    public void setIs_follow(int is_follow) {
        this.is_follow = is_follow;
    }
}
