package com.waw.hr.service;

import com.waw.hr.core.Result;
import com.waw.hr.entity.EmployeeSignLog;

import java.util.List;

public interface EmployeeSignLogService {

    Result doEmployeeSign(Integer employeeId, String time);

    Result getEmployeeSignLogList(Integer role, Integer uid, Integer page, Integer size);

    List<EmployeeSignLog> getEmployeeSignLogListByEmployeeId(Integer employeeId);

}
