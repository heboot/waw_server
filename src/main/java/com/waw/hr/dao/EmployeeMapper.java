package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.BanlanceEntity;
import com.waw.hr.entity.EmployeeBank;
import com.waw.hr.entity.RecommendUser;
import com.waw.hr.model.AdminUserModel;
import com.waw.hr.entity.Employee;
import com.waw.hr.model.ApplyModel;
import com.waw.hr.model.EmployeeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper extends Mapper<Employee> {

    Integer registerEmployee(@Param("name") String name, @Param("mobile") String mobile, @Param("time") String time, @Param("createId") String createId, @Param("brokerId") String brokerId);// @Param("barCode") String barCode, @Param("barCodePic") String barCodePic

    Integer updateBarCode(@Param("uid") String uid, @Param("barCode") String barCode, @Param("barCodePic") String barCodePic);

    Integer updateEmployeeStatus(@Param("id") Integer id, @Param("status") Integer status);

    Integer updateEmployeeJobStatus(@Param("id") Integer id, @Param("status") Integer status);

    Integer updateEmployeeCashStatus(@Param("id") Integer id, @Param("status") Integer status);

    Integer updateEmployeeBroker(@Param("id") Integer id, @Param("brokerId") Integer brokerId);

    EmployeeModel getEmployeeByMobile(@Param("mobile") String mobile);

    Integer updateEmployeeJoinWorkTime(@Param("id") Integer id, @Param("time") String time);

    Integer updateEmployeeName(@Param("id") Integer id, @Param("name") String name);

    Integer updateEmployeeAvatar(@Param("id") Integer id, @Param("avatar") String avatar);

    Integer updateEmployeeSex(@Param("id") Integer id, @Param("sex") int sex);

    Integer updateEmployeeIDCardInfo(@Param("id") Integer id, @Param("id_card_pic_face") String id_card_pic_face, @Param("id_card_pic") String id_card_pic);

    List<Employee> getEmployeeList(@Param("key") String key);

    List<Employee> getEmployeeListByParentID(@Param("parentId") Integer parentId, @Param("key") String key);

    List<Employee> getEmployeeListByBrokerId(@Param("brokerId") Integer BrokerId, @Param("key") String key);

    AdminUserModel getMyBroker(@Param("brokerId") String borkerId);

    Integer updateEmployeeInfo(@Param("uid") String uid, @Param("name") String name, @Param("avatar") String avatar, @Param("sex") Integer sex);

    EmployeeModel getEmployeeById(@Param("id") String id);

    Integer updateEmployeeIdCardPic(@Param("uid") String uid, @Param("picFace") String picFace, @Param("pic") String pic, @Param("idStatus") int idStatus);

    Integer updateEmployeeBarkCardInfo(@Param("uid") String uid, @Param("bankId") String bankId, @Param("bankName") String bankName, @Param("bankCode") String bankCode, @Param("picFront") String bankPicFront, @Param("picReverse") String bankPicReverse, @Param("time") String time);

    Integer insertEmployeeBarkCardInfo(@Param("uid") String uid, @Param("bankId") String bankId, @Param("bankCode") String bankCode, @Param("picFront") String bankPicFront, @Param("picReverse") String bankPicReverse);

    Integer recommendUser(@Param("uid") String uid, @Param("name") String name, @Param("mobile") String mobile, @Param("time") String time);

    //根据手机号查询这个人是否被推荐过
    RecommendUser getRecommendUserByMobile(@Param("mobile") String mobile);

    //获取我推荐的列表
    List<RecommendUser> getMyRecommendUserList(@Param("uid") String uid);

    /**
     * 获取有身份证信息的员工列表
     *
     * @return
     */
    List<Employee> getIdCardList();

    //分配经纪人 返回经纪人ID
    List<String> switchBroker();


    //获取我录入的员工列表
    List<Employee> getEmployeeListByCreateId(@Param("createId") String createId, @Param("key") String key);

    //获取员工的身份证审核信息
    List<EmployeeBank> getEmployeeBankList();

    //查询这个员工是否认证过银行卡
    Integer getEmployeeBankInfoCount(@Param("uid") String uid);

    //获取某个员工的最新的身份证认证信息
    EmployeeBank getEmployeeBankInfoById(@Param("uid") String uid);

    Integer updateEmployeeBankStatus(@Param("uid") String uid, @Param("status") int status);

    //获取某个员工的账户记录
    List<BanlanceEntity> getEmployeeBalanceLog(@Param("uid") String uid);

    Employee getEmployeeByBarCode(@Param("barCode") String barCode);

    //获取报名列表
    List<ApplyModel> getApplyEmployeeList();

    Employee getEmployeeDataById(@Param("id") String uid);

    Integer updateEmployeeBankStatus(@Param("id") Integer id, @Param("status") Integer status);

    Integer updateEmployeeIDCradStatus(@Param("id") Integer id, @Param("status") Integer status);

    //更换经纪人
    Integer changeBroker(@Param("uid") String id, @Param("remark") String remark, @Param("brokerId") String brokerId, @Param("newBrokerId") String newBrokerId, @Param("time") String time);

    //查询上次更换经纪人的时间
    String getChangeBrokerTime(@Param("uid") String uid);

}
