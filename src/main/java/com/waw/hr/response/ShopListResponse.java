package com.waw.hr.response;

import com.waw.hr.model.ShopListModel;

import java.util.List;

public class ShopListResponse {

    private List<ShopListModel> list;

    public List<ShopListModel> getList() {
        return list;
    }

    public void setList(List<ShopListModel> list) {
        this.list = list;
    }
}
