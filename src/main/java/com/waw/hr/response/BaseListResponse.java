package com.waw.hr.response;

public class BaseListResponse extends BaseResponse {

    protected int page;

    protected int size;

    protected int totalPage;

    protected int total;


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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public BaseListResponse(int page, int size, int totalPage) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
    }

    public BaseListResponse(int page, int size, int totalPage, int total) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.total = total;
    }

    public BaseListResponse() {
    }
}
