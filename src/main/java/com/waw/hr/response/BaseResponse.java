package com.waw.hr.response;

public class BaseResponse {

    protected int page;

    protected int size;

    protected int totalPage;

    protected String token;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public BaseResponse(int page, int size, int totalPage, String token) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.token = token;
    }

    public BaseResponse(String token) {
        this.token = token;
    }

    public BaseResponse() {
    }
}
