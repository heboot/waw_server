package com.waw.hr.response;

import com.waw.hr.entity.CashLogModel;
import com.waw.hr.model.JoinModel;

import java.util.List;

public class CashListResponse extends BaseListResponse {

    private List<CashLogModel> list;

    public List<CashLogModel> getList() {
        return list;
    }

    public void setList(List<CashLogModel> list) {
        this.list = list;
    }

    public CashListResponse(int page, int size, int totalPage, int total, List<CashLogModel> list) {
        super(page, size, totalPage, total);
        this.list = list;
    }
}
