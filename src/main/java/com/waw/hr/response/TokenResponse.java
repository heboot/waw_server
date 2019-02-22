package com.waw.hr.response;

public class TokenResponse {


    protected String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenResponse(String token) {
        this.token = token;
    }
}
