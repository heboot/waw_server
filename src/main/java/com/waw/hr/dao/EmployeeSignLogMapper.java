package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;
import com.waw.hr.entity.EmployeeSignLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeSignLogMapper extends Mapper<EmployeeSignLog> {

    Integer doEmployeeSign(@Param("employeeId") Integer employeeId, @Param("time") String time);

    List<EmployeeSignLog> getEmployeeSignLogListByParentId(@Param("parentId") Integer parentId);

    List<EmployeeSignLog> getEmployeeSignLogListByBrokerId(@Param("brokerId") Integer brokerId);

    List<EmployeeSignLog> getEmployeeSignLogList();

    List<EmployeeSignLog> getEmployeeSignLogListByEmployeeId(@Param("employeeId") Integer employeeId);
}
