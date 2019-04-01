package com.waw.hr.response;

import com.waw.hr.model.ApplyModel;

import java.util.List;

public class ApplyListResponse extends BaseListResponse {

    private List<ApplyModel> list;

    public List<ApplyModel> getList() {
        return list;
    }

    public void setList(List<ApplyModel> list) {
        this.list = list;
    }

    public ApplyListResponse(int page, int size, int totalPage, int total, List<ApplyModel> list) {
        super(page, size, totalPage, total);
        this.list = list;
    }
}
