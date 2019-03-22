package com.waw.hr.response;

import com.waw.hr.entity.Employee;

import java.util.List;

public class GetEmployeeListListResponse extends BaseListResponse {

    private List<Employee> list;

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    public GetEmployeeListListResponse(int page, int size, int totalPage, List<Employee> list) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
    }

    public GetEmployeeListListResponse(int page, int size, int totalPage, List<Employee> list, int total) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
        this.total = total;
    }
}
