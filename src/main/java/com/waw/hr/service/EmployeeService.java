package com.waw.hr.service;

import com.waw.hr.core.Result;
import com.waw.hr.entity.*;
import com.waw.hr.model.AdminUserModel;
import com.waw.hr.model.ApplyModel;
import com.waw.hr.model.EmployeeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeService {


    Integer registerEmployee(String mobile, String name, String time, String createId);

    Integer updateEmployeeStatus(Integer id, Integer status);

    Integer updateEmployeeJobStatus(Integer id, Integer status);

    Integer updateEmployeeCashStatus(Integer id, Integer status);

    Integer updateEmployeeBankStatus(Integer id, Integer status);

    Integer updateEmployeeIDCradStatus(Integer id, Integer status);

    Integer updateEmployeeBroker(Integer id, Integer brokerId);

    Result doLogin(String mobile, String smsCode);

    Integer updateEmployeeName(Integer id, String name);

    String updateEmployeeAvatar(Integer id, String avatar);

    List<Employee> getEmployeeList(String key);

    List<Employee> getEmployeeListByParentID(Integer parentId, String key);

    List<Employee> getEmployeeListByBrokerId(Integer BrokerId, String key);

    AdminUserModel getMyBroker(String borkerId);

    Integer updateEmployeeInfo(String uid, String name, String avatar, Integer sex);

    EmployeeModel getEmployeeById(String id);


    Employee getEmployeeByBarCode(String barCode);

    Integer updateEmployeeIdCardPic(String uid, String picFace, String pic, int status);

    Integer updateEmployeeBarkCardInfo(String uid, String bankId, String name, String bankCode, String bankPicFront, String bankPicReverse, String time);


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

    //获取员工的身份证审核信息
    List<EmployeeBank> getEmployeeBankList();

    //获取某个员工的最新的身份证认证信息
    EmployeeBank getEmployeeBankInfoById(String uid);

    //获取某个员工的账户记录
    List<BanlanceEntity> getEmployeeBalanceLog(String uid);

    //获取报名列表
    List<ApplyModel> getApplyEmployeeList();


    //获取入职列表
    List<ApplyModel> getJoinEmployeeList();

    //更换经纪人
    AdminUserModel changeBroker(String id, String remark);

    //查询上次更换经纪人的时间
    String getChangeBrokerTime(String uid);
}
