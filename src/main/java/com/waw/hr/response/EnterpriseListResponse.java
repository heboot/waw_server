package com.waw.hr.response;

import com.waw.hr.entity.Enterprise;
import com.waw.hr.entity.EnterpriseListModel;

import java.util.List;

public class EnterpriseListResponse extends BaseListResponse {

    private List<EnterpriseListModel> list;

    public List<EnterpriseListModel> getList() {
        return list;
    }

    public void setList(List<EnterpriseListModel> list) {
        this.list = list;
    }

    public EnterpriseListResponse(int page, int size, int totalPage, List<EnterpriseListModel> list) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
    }
}
