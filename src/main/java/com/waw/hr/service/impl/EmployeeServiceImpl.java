package com.waw.hr.service.impl;

import com.waw.hr.CommonValue;
import com.waw.hr.core.*;
import com.waw.hr.dao.AdminUserMapper;
import com.waw.hr.dao.EmployeeMapper;
import com.waw.hr.entity.BanlanceEntity;
import com.waw.hr.entity.EmployeeBank;
import com.waw.hr.entity.RecommendUser;
import com.waw.hr.model.AdminUserModel;
import com.waw.hr.entity.Employee;
import com.waw.hr.model.ApplyModel;
import com.waw.hr.model.EmployeeModel;
import com.waw.hr.response.LoginResponse;
import com.waw.hr.service.EmployeeService;
import com.waw.hr.utils.BarcodeUtil2;
import com.waw.hr.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class EmployeeServiceImpl extends AbstractService<Employee> implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Autowired
    private BarcodeUtil2 barcodeUtil2;


    @Override
    public Integer registerEmployee(String mobile, String name, String time, String createId) {
        String brokerId = String.valueOf(switchBroker());

        Integer insertId = employeeMapper.registerEmployee(name, mobile, time, createId, brokerId);

        EmployeeModel employeeModel = employeeMapper.getEmployeeByMobile(mobile);

        String barCode = barcodeUtil2.getUserBarCode("waw" + String.valueOf(employeeModel.getId()), brokerId, "00", null);

        String qiniuKey = "barcode/register/ " + String.valueOf(employeeModel.getId()) + "/" + System.currentTimeMillis() + ".png";

        barcodeUtil2.executeBarcode(qiniuKey, barCode);

        employeeMapper.updateBarCode(String.valueOf(employeeModel.getId()), barCode, qiniuKey);

        return insertId;
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

            Integer result = registerEmployee(mobile, "", String.valueOf(System.currentTimeMillis()), null);
            if (result != null && result > 0) {
                EmployeeModel employee = employeeMapper.getEmployeeByMobile(mobile);

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
        EmployeeModel employee = employeeMapper.getEmployeeByMobile(mobile);
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
    public AdminUserModel getMyBroker(String borkerId) {
        return employeeMapper.getMyBroker(borkerId);
    }

    @Override
    public Integer updateEmployeeInfo(String uid, String name, String avatar, String sex) {
        return employeeMapper.updateEmployeeInfo(uid, name, avatar, sex);
    }

    @Override
    public EmployeeModel getEmployeeById(String id) {
        return employeeMapper.getEmployeeById(id);
    }

    @Override
    public Employee getEmployeeByBarCode(String barCode) {
        return employeeMapper.getEmployeeByBarCode(barCode);
    }

    @Override
    public Integer updateEmployeeIdCardPic(String uid, String picFace, String pic, int status) {
        return employeeMapper.updateEmployeeIdCardPic(uid, picFace, pic, status);
    }

    @Override
    public Integer updateEmployeeBarkCardInfo(String uid, String bankId, String name, String bankCode, String bankPicFront, String bankPicReverse, String time) {
        Integer result = employeeMapper.updateEmployeeBarkCardInfo(uid, bankId, name, bankCode, bankPicFront, bankPicFront, String.valueOf(System.currentTimeMillis()));
        if (result != null && result > 0) {
            employeeMapper.updateEmployeeBankStatus(uid, AuthStatus.ING.code());
        }
        return employeeMapper.updateEmployeeBarkCardInfo(uid, bankId, name, bankCode, bankPicFront, bankPicFront, String.valueOf(System.currentTimeMillis()));
    }

    @Override
    public Integer recommendUser(String uid, String name, String mobile) {
        return employeeMapper.recommendUser(uid, name, mobile, String.valueOf(System.currentTimeMillis()));
    }

    @Override
    public RecommendUser getRecommendUserByMobile(String mobile) {
        return employeeMapper.getRecommendUserByMobile(mobile);
    }

    @Override
    public List<RecommendUser> getMyRecommendUserList(String uid) {
        return employeeMapper.getMyRecommendUserList(uid);
    }

    private Random random = new Random();

    @Override
    public String switchBroker() {

        List<String> brokerIds = employeeMapper.switchBroker();

        String resultId = null;

        if (brokerIds.size() > 1) {
            resultId = brokerIds.get(random.nextInt(brokerIds.size() - 1));
        } else {
            resultId = brokerIds.get(0);
        }

        return resultId;
    }

    @Override
    public List<Employee> getEmployeeListByCreateId(String createId, String key) {
        return employeeMapper.getEmployeeListByCreateId(createId, key);
    }

    @Override
    public List<EmployeeBank> getEmployeeBankList() {
        return employeeMapper.getEmployeeBankList();
    }

    @Override
    public EmployeeBank getEmployeeBankInfoById(String uid) {
        return employeeMapper.getEmployeeBankInfoById(uid);
    }

    @Override
    public List<BanlanceEntity> getEmployeeBalanceLog(String uid) {
        return employeeMapper.getEmployeeBalanceLog(uid);
    }

    @Override
    public List<ApplyModel> getApplyEmployeeList() {
        return employeeMapper.getApplyEmployeeList();
    }

}
