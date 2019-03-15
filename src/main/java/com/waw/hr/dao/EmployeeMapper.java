package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.AdminUser;
import com.waw.hr.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper extends Mapper<Employee> {

    Integer registerEmployee(@Param("name") String name, @Param("mobile") String mobile, @Param("time") String time);

    Integer updateEmployeeStatus(@Param("id") Integer id, @Param("status") Integer status);

    Integer updateEmployeeJobStatus(@Param("id") Integer id, @Param("status") Integer status);

    Integer updateEmployeeCashStatus(@Param("id") Integer id, @Param("status") Integer status);

    Integer updateEmployeeBroker(@Param("id") Integer id, @Param("brokerId") Integer brokerId);

    Employee getEmployeeByMobile(@Param("mobile") String mobile);

    Integer updateEmployeeJoinWorkTime(@Param("id") Integer id, @Param("time") String time);

    Integer updateEmployeeName(@Param("id") Integer id, @Param("name") String name);

    Integer updateEmployeeAvatar(@Param("id") Integer id, @Param("avatar") String avatar);

    Integer updateEmployeeSex(@Param("id") Integer id, @Param("sex") int sex);

    Integer updateEmployeeIDCardInfo(@Param("id") Integer id, @Param("id_card_pic_face") String id_card_pic_face, @Param("id_card_pic") String id_card_pic);

    List<Employee> getEmployeeList(@Param("key") String key);

    List<Employee> getEmployeeListByParentID(@Param("parentId") Integer parentId, @Param("key") String key);

    List<Employee> getEmployeeListByBrokerId(@Param("brokerId") Integer BrokerId, @Param("key") String key);

    AdminUser getMyBroker(@Param("brokerId") String borkerId);

    Integer updateEmployeeInfo(@Param("uid") String uid, @Param("name") String name, @Param("avatar") String avatar, @Param("sex") String sex);

    Employee getEmployeeById(@Param("id") String id);

    Integer updateEmployeeIdCardPic(@Param("uid") String uid, @Param("picFace") String picFace, @Param("pic") String pic, @Param("status") int status);

    Integer updateEmployeeBarkCardInfo(@Param("uid") String uid, @Param("picFront") String bankPicFront, @Param("picReverse") String bankPicReverse);
}
