package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeSignLogMapper extends Mapper<AdminUser> {
    Integer doEmployeeSign(Integer employeeId, String time);
}
