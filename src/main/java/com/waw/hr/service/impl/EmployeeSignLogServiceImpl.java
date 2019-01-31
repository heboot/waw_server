package com.waw.hr.service.impl;

import com.waw.hr.core.AbstractService;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.dao.EmployeeMapper;
import com.waw.hr.dao.EmployeeSignLogMapper;
import com.waw.hr.entity.Employee;
import com.waw.hr.service.EmployeeService;
import com.waw.hr.service.EmployeeSignLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class EmployeeSignLogServiceImpl extends AbstractService<Employee> implements EmployeeSignLogService {

    @Resource
    private EmployeeSignLogMapper employeeSignLogMapper;

    @Override
    public Result doEmployeeSign(Integer employeeId, String time) {
        // TODO: 2019/1/31 根据时间判断 当天不能签两次到
        int result = employeeSignLogMapper.doEmployeeSign(employeeId, time);
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("");
    }
}
