package com.waw.hr.response;

import com.waw.hr.entity.Enterprise;

import java.util.List;

public class GetAllEnterpriseListResponse extends BaseListResponse {

    private List<Enterprise> list;

    public List<Enterprise> getList() {
        return list;
    }

    public void setList(List<Enterprise> list) {
        this.list = list;
    }

    public GetAllEnterpriseListResponse(int page, int size, int totalPage, List<Enterprise> list) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
    }

    public GetAllEnterpriseListResponse(int page, int size, int totalPage, List<Enterprise> list, int total) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
        this.total = total;
    }
}
