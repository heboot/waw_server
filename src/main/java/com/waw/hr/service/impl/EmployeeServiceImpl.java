package com.waw.hr.service.impl;

import com.waw.hr.core.AbstractService;
import com.waw.hr.core.MValue;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.dao.EmployeeMapper;
import com.waw.hr.entity.Employee;
import com.waw.hr.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl extends AbstractService<Employee> implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public Integer registerEmployee(String mobile, String name, String time) {
        return employeeMapper.registerEmployee(name, mobile, time);
    }

    @Override
    public Integer updateEmployeeStatus(Integer id, Integer status) {
        return employeeMapper.updateEmployeeStatus(id, status);
    }

    @Override
    public Integer updateEmployeeJobStatus(Integer id, Integer status) {
        return employeeMapper.updateEmployeeJobStatus(id, status);
    }

    @Override
    public Integer updateEmployeeCashStatus(Integer id, Integer status) {
        return employeeMapper.updateEmployeeCashStatus(id, status);
    }

    @Override
    public Integer updateEmployeeBroker(Integer id, Integer brokerId) {
        return employeeMapper.updateEmployeeBroker(id, brokerId);
    }

    @Override
    public Result doLogin(String mobile, String smsCode) {
        // TODO: 2019/1/31 验证验证码是否准确
        //验证码正确之后
        if (employeeMapper.getEmployeeByMobile(mobile) == null) {
            Integer result = registerEmployee(mobile, "", String.valueOf(System.currentTimeMillis()));
            if (result != null && result > 0) {
                return ResultGenerator.genSuccessResult(employeeMapper.getEmployeeByMobile(mobile));
            }
            return ResultGenerator.genFailResult(MValue.MESSAGE_LOGIN_FAIL);
        }
        return ResultGenerator.genSuccessResult(employeeMapper.getEmployeeByMobile(mobile));
    }

    @Override
    public Integer updateEmployeeName(Integer id, String name) {
        return employeeMapper.updateEmployeeName(id, name);
    }

    @Override
    public String updateEmployeeAvatar(Integer id, String avatar) {
        // TODO: 2019/1/31 接入七牛SDK 上传头像数据 返回Url 再入库

        return null;
    }

    @Override
    public List<Employee> getEmployeeList(String key) {
        return employeeMapper.getEmployeeList(key);
    }

    @Override
    public List<Employee> getEmployeeListByParentID(Integer parentId,String key) {
        return employeeMapper.getEmployeeListByParentID(parentId,key);
    }

    @Override
    public List<Employee> getEmployeeListByBrokerId(Integer BrokerId,String key) {
        return employeeMapper.getEmployeeListByBrokerId(BrokerId,key);
    }
}
