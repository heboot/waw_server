package com.waw.hr.service.impl;

import com.github.pagehelper.PageInfo;
import com.waw.hr.core.AbstractService;
import com.waw.hr.core.ROLE;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.dao.EmployeeSignLogMapper;
import com.waw.hr.entity.EmployeeSignLog;
import com.waw.hr.response.GetEmployeeSignLogListListResponse;
import com.waw.hr.service.EmployeeSignLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EmployeeSignLogServiceImpl extends AbstractService<EmployeeSignLog> implements EmployeeSignLogService {

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

    @Override
    public Result getEmployeeSignLogList(Integer role, Integer uid, Integer page, Integer size) {
        List<EmployeeSignLog> employeeSignLogList = null;
        if (role == ROLE.ROLE_ADMIN) {
            employeeSignLogList = employeeSignLogMapper.getEmployeeSignLogList();
        } else if (role == ROLE.ROLE_EDITOR) {
            employeeSignLogList = employeeSignLogMapper.getEmployeeSignLogListByParentId(uid);
        } else if (role == ROLE.ROLE_BROKER) {
            employeeSignLogList = employeeSignLogMapper.getEmployeeSignLogListByBrokerId(uid);
        }
        PageInfo<EmployeeSignLog> pageInfo = new PageInfo<>(employeeSignLogList);
        return ResultGenerator.genSuccessResult(new GetEmployeeSignLogListListResponse(page, size, (int) pageInfo.getTotal(), pageInfo.getList()));
    }

    @Override
    public List<EmployeeSignLog> getEmployeeSignLogListByEmployeeId(Integer employeeId) {
        return null;
    }

}
