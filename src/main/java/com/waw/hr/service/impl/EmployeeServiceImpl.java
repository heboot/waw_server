package com.waw.hr.service.impl;

import com.waw.hr.CommonValue;
import com.waw.hr.core.AbstractService;
import com.waw.hr.core.MValue;
import com.waw.hr.core.Result;
import com.waw.hr.core.ResultGenerator;
import com.waw.hr.dao.AdminUserMapper;
import com.waw.hr.dao.EmployeeMapper;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;
import com.waw.hr.response.LoginResponse;
import com.waw.hr.service.EmployeeService;
import com.waw.hr.utils.JWTUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl extends AbstractService<Employee> implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private AdminUserMapper adminUserMapper;

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
        //验证码正确之后
        if (employeeMapper.getEmployeeByMobile(mobile) == null) {
//            if (adminUserMapper.getAdminUserByMobile(mobile) == null) {
            Integer result = registerEmployee(mobile, "", String.valueOf(System.currentTimeMillis()));
            if (result != null && result > 0) {
                Employee employee = employeeMapper.getEmployeeByMobile(mobile);
                LoginResponse loginResponse = new LoginResponse(JWTUtil.signById(String.valueOf(employee.getId()), CommonValue.SECRET), employee);
                return ResultGenerator.genSuccessResult(loginResponse);
            }
//            }
            //这个手机号是管理员
//            else {
//                AdminUser adminUser = adminUserMapper.getAdminUserByMobile(mobile);
//                LoginResponse loginResponse = new LoginResponse(JWTUtil.signById(String.valueOf(adminUser.getId()), CommonValue.SECRET), adminUser);
//                return ResultGenerator.genSuccessResult(loginResponse);
//            }
            return ResultGenerator.genFailResult(MValue.MESSAGE_LOGIN_FAIL);
        }
        Employee employee = employeeMapper.getEmployeeByMobile(mobile);
        LoginResponse loginResponse = new LoginResponse(JWTUtil.signById(String.valueOf(employee.getId()), CommonValue.SECRET), employee);
        return ResultGenerator.genSuccessResult(loginResponse);
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
    public List<Employee> getEmployeeListByParentID(Integer parentId, String key) {
        return employeeMapper.getEmployeeListByParentID(parentId, key);
    }

    @Override
    public List<Employee> getEmployeeListByBrokerId(Integer BrokerId, String key) {
        return employeeMapper.getEmployeeListByBrokerId(BrokerId, key);
    }

    @Override
    public AdminUser getMyBroker(String borkerId) {
        return employeeMapper.getMyBroker(borkerId);
    }

    @Override
    public Integer updateEmployeeInfo(String uid, String name, String avatar, String sex) {
        return employeeMapper.updateEmployeeInfo(uid, name, avatar, sex);
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeMapper.getEmployeeById(id);
    }

    @Override
    public Integer updateEmployeeIdCardPic(String uid, String picFace, String pic, int status) {
        return employeeMapper.updateEmployeeIdCardPic(uid, picFace, pic, status);
    }

    @Override
    public Integer updateEmployeeBarkCardInfo(String uid, String bankPicFront, String bankPicReverse) {
        return null;
    }
}
