package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;
import com.waw.hr.entity.EmployeeSignLog;
import org.apache.ibatis.annotations.Param;

public interface EmployeeSignLogMapper extends Mapper<EmployeeSignLog> {
    Integer doEmployeeSign(Integer employeeId, String time);
}
