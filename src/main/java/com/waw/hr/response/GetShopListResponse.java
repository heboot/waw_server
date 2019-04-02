package com.waw.hr.response;

import com.waw.hr.entity.ShopEntity;

import java.util.List;

public class GetShopListResponse extends BaseListResponse {

    private List<ShopEntity> list;

    public List<ShopEntity> getList() {
        return list;
    }

    public void setList(List<ShopEntity> list) {
        this.list = list;
    }

    public GetShopListResponse(int page, int size, int totalPage, int total, List<ShopEntity> list) {
        super(page, size, totalPage, total);
        this.list = list;
    }
}
