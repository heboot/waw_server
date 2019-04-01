package com.waw.hr.service.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.waw.hr.core.AbstractService;
import com.waw.hr.dao.EmployeeMapper;
import com.waw.hr.dao.EnterpriseMapper;
import com.waw.hr.entity.Enterprise;
import com.waw.hr.model.EmployeeModel;
import com.waw.hr.model.EnterpriseListModel;
import com.waw.hr.service.EnterpriseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EnterpriseServiceImpl extends AbstractService<Enterprise> implements EnterpriseService {

    @Resource
    private EnterpriseMapper enterpriseMapper;

    @Resource
    private EmployeeMapper employeeMapper;


    @Override
    public Integer is_follow(String uid, String enterpriseId) {
        return enterpriseMapper.is_follow(uid, enterpriseId);
    }

    @Override
    public Integer is_join(String uid, String enterpriseId) {
        return enterpriseMapper.is_join(uid, enterpriseId);
    }


    @Override
    public List<Enterprise> getEnterpriseList(String key, Integer sort) {
        return enterpriseMapper.getEnterpriseList(key, sort);
    }

    @Override
    public List<EnterpriseListModel> enterpriseList(String key, Integer sort) {
        return enterpriseMapper.enterpriseList(key, sort);
    }

    @Override
    public List<Enterprise> getEnterpriseByName(String name) {
        return enterpriseMapper.getEnterpriseByName(name);
    }

    @Override
    public Integer removeEnterprise(Integer id) {
        return enterpriseMapper.removeEnterprise(id);
    }

    @Override
    public Enterprise getEnterpriseById(String id) {
        return enterpriseMapper.getEnterpriseById(id);
    }

    @Override
    public Integer updateEnterprise(Enterprise enterprise) {
        return enterpriseMapper.updateEnterprise(enterprise);
    }

    @Override
    public Integer addEnterprise(Enterprise enterprise) {
        return enterpriseMapper.addEnterprise(enterprise);
    }

    @Override
    public Integer updateEnterpriseSubsidy(String id, Integer money, String info) {
        return enterpriseMapper.updateEnterpriseSubsidy(id, money, info);
    }

    @Override
    public Integer followEnterprise(String uid, String enterpriseId, int type) {
        if (type == 0) {
            return enterpriseMapper.unfollowEnterprise(uid, enterpriseId);
        }
        return enterpriseMapper.followEnterprise(uid, enterpriseId);
    }

    @Override
    public Integer join(String uid, String enterpriseId, String time) {

//        EmployeeModel employeeModel = employeeMapper.getEmployeeById(uid);
//
//        Enterprise enterprise = enterpriseMapper.getEnterpriseById(enterpriseId);
//
//        String smsContent = StringUtils.isEmpty(employeeModel.getName()) ? "有新用户" : employeeModel.getName() + "报名了" + enterprise.getName() + "，电话:" + employeeModel.getMobile()

//        Map<String, Object> parameters = new HashMap<String, Object>();
//        parameters.put("order_id", "7623432424540");      // 使用实际的值来替换模板中的变量
//        try {
//            AVOSCloud.requestSMSCode("186xxxxxxxx", "Order_Notice", parameters);
//        } catch (AVException e) {
//        }

        return enterpriseMapper.join(uid, enterpriseId, time);
    }

    @Override
    public List<Enterprise> getMyEnterpriseList(String uid) {
        return enterpriseMapper.getMyEnterpriseList(uid);
    }


}
