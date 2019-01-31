package com.waw.hr.service;

import com.waw.hr.core.Result;

public interface EmployeeSignLogService {

    Result doEmployeeSign(Integer employeeId, String time);

}
