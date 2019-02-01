package com.waw.hr.response;

import com.waw.hr.entity.EmployeeSignLog;

import java.util.List;

public class GetEmployeeSignLogListResponse extends BaseResponse {

    private List<EmployeeSignLog> list;

    public List<EmployeeSignLog> getList() {
        return list;
    }

    public void setList(List<EmployeeSignLog> list) {
        this.list = list;
    }

    public GetEmployeeSignLogListResponse(int page, int size, int totalPage, List<EmployeeSignLog> list) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
    }
}
