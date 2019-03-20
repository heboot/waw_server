package com.waw.hr.service;

import com.waw.hr.core.Result;
import com.waw.hr.model.AdminUserModel;
import com.waw.hr.entity.Employee;
import com.waw.hr.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {


    Integer registerEmployee(String mobile, String name, String time);

    Integer updateEmployeeStatus(Integer id, Integer status);

    Integer updateEmployeeJobStatus(Integer id, Integer status);

    Integer updateEmployeeCashStatus(Integer id, Integer status);

    Integer updateEmployeeBroker(Integer id, Integer brokerId);

    Result doLogin(String mobile, String smsCode);

    Integer updateEmployeeName(Integer id, String name);

    String updateEmployeeAvatar(Integer id, String avatar);

    List<Employee> getEmployeeList(String key);

    List<Employee> getEmployeeListByParentID(Integer parentId, String key);

    List<Employee> getEmployeeListByBrokerId(Integer BrokerId, String key);

    AdminUserModel getMyBroker(String borkerId);

    Integer updateEmployeeInfo(String uid, String name, String avatar, String sex);

    EmployeeModel getEmployeeById(String id);

    Integer updateEmployeeIdCardPic(String uid, String picFace, String pic, int status);

    Integer updateEmployeeBarkCardInfo(String uid, String bankPicFront, String bankPicReverse);

}
