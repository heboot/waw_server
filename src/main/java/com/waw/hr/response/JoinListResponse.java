package com.waw.hr.response;

import com.waw.hr.model.ApplyModel;
import com.waw.hr.model.JoinModel;

import java.util.List;

public class JoinListResponse extends BaseListResponse {

    private List<JoinModel> list;

    public List<JoinModel> getList() {
        return list;
    }

    public void setList(List<JoinModel> list) {
        this.list = list;
    }

    public JoinListResponse(int page, int size, int totalPage, int total, List<JoinModel> list) {
        super(page, size, totalPage, total);
        this.list = list;
    }
}
