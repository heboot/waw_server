package com.waw.hr.response;

import com.waw.hr.entity.Employee;
import com.waw.hr.entity.Enterprise;

import java.util.List;

public class GetEmployeeListResponse extends BaseResponse {

    private List<Employee> list;

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    public GetEmployeeListResponse(int page, int size, int totalPage, List<Employee> list) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
    }
}
