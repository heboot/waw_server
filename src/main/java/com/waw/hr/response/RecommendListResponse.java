package com.waw.hr.response;

import com.waw.hr.entity.CashLogModel;
import com.waw.hr.entity.RecommendUser;

import java.util.List;

public class RecommendListResponse extends BaseListResponse {

    private List<RecommendUser> list;

    public List<RecommendUser> getList() {
        return list;
    }

    public void setList(List<RecommendUser> list) {
        this.list = list;
    }

    public RecommendListResponse(int page, int size, int totalPage, int total, List<RecommendUser> list) {
        super(page, size, totalPage, total);
        this.list = list;
    }
}
