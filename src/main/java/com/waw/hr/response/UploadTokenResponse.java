package com.waw.hr.response;

public class UploadTokenResponse {
    public UploadTokenResponse(String uploadToken) {
        this.uploadToken = uploadToken;
    }

    private String uploadToken;

    public String getUploadToken() {
        return uploadToken;
    }

    public void setUploadToken(String uploadToken) {
        this.uploadToken = uploadToken;
    }
}
