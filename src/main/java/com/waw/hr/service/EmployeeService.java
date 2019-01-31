package com.waw.hr.service;

import com.waw.hr.core.Result;
import com.waw.hr.entity.Employee;

public interface EmployeeService {


    Integer registerEmployee(String mobile, String name, String time);

    Integer updateEmployeeStatus(Integer id, Integer status);

    Integer updateEmployeeBroker(Integer id, Integer brokerId);

    Result doLogin(String mobile, String smsCode);

    Integer updateEmployeeName(Integer id, String name);

    String updateEmployeeAvatar(Integer id, String avatar);

}
