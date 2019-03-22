package com.waw.hr.response;

import com.waw.hr.entity.Enterprise;
import com.waw.hr.entity.RecommendUser;

import java.util.List;

public class MyRecommendListResponse extends BaseListResponse {

    private List<RecommendUser> list;

    public List<RecommendUser> getList() {
        return list;
    }

    public void setList(List<RecommendUser> list) {
        this.list = list;
    }

    public MyRecommendListResponse(int page, int size, int totalPage, List<RecommendUser> list) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
    }
}
