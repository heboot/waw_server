package com.waw.hr.response;

import com.waw.hr.entity.AdminUser;

import java.util.List;

public class GetAdminUserListListResponse extends BaseListResponse {

    private List<AdminUser> list;

    public List<AdminUser> getList() {
        return list;
    }

    public void setList(List<AdminUser> list) {
        this.list = list;
    }

    public GetAdminUserListListResponse(int page, int size, int totalPage, List<AdminUser> list) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
    }
}
