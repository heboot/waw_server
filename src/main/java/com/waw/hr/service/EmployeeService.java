package com.waw.hr.service;

import com.waw.hr.core.Result;
import com.waw.hr.entity.RecommendUser;
import com.waw.hr.model.AdminUserModel;
import com.waw.hr.entity.Employee;
import com.waw.hr.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {


    Integer registerEmployee(String mobile, String name, String time, String createId );

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

    Integer updateEmployeeBarkCardInfo(String uid, String bankId, String bankCode, String bankPicFront, String bankPicReverse);


    //推荐用户
    Integer recommendUser(String uid, String name, String mobile);

    //根据手机号查询这个人是否被推荐过
    RecommendUser getRecommendUserByMobile(String mobile);

    //获取我推荐的列表
    List<RecommendUser> getMyRecommendUserList(String uid);

    //分配经纪人 返回经纪人ID
    String switchBroker();

    //获取我录入的员工列表
    List<Employee> getEmployeeListByCreateId(String createId, String key);

}
