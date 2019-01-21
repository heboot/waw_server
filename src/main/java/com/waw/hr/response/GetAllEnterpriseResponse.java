package com.waw.hr.response;

import com.waw.hr.entity.Enterprise;

import java.util.List;

public class GetAllEnterpriseResponse extends BaseResponse {

    private List<Enterprise> data;

    public List<Enterprise> getData() {
        return data;
    }

    public void setData(List<Enterprise> data) {
        this.data = data;
    }

    public GetAllEnterpriseResponse(int page, int size, int totalPage, List<Enterprise> data) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.data = data;
    }
}
