package com.waw.hr.response;

import com.waw.hr.entity.Employee;
import com.waw.hr.entity.EmployeeBank;

import java.util.List;

public class GetEmployeeBankListResponse extends BaseListResponse {

    private List<EmployeeBank> list;

    public List<EmployeeBank> getList() {
        return list;
    }

    public void setList(List<EmployeeBank> list) {
        this.list = list;
    }

    public GetEmployeeBankListResponse(int page, int size, int totalPage, List<EmployeeBank> list) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
    }

    public GetEmployeeBankListResponse(int page, int size, int totalPage, List<EmployeeBank> list, int total) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
        this.total = total;
    }
}
