package com.waw.hr.response;

import com.waw.hr.entity.BanlanceEntity;
import com.waw.hr.entity.RecommendUser;

import java.util.List;

public class MyBalanceListResponse extends BaseListResponse {

    private List<BanlanceEntity> list;

    public List<BanlanceEntity> getList() {
        return list;
    }

    public void setList(List<BanlanceEntity> list) {
        this.list = list;
    }


    public MyBalanceListResponse(int page, int size, int totalPage, int total, List<BanlanceEntity> list) {
        super(page, size, totalPage, total);
        this.list = list;
    }
}
