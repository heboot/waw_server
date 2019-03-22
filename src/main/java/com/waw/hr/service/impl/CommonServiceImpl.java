package com.waw.hr.service.impl;

import com.waw.hr.core.AbstractService;
import com.waw.hr.dao.CommonMapper;
import com.waw.hr.entity.FeedBackEntity;
import com.waw.hr.service.CommonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CommonServiceImpl extends AbstractService<FeedBackEntity> implements CommonService {

    @Resource
    private CommonMapper commonMapper;

    @Override
    public Integer feedback(String uid, String content) {
        return commonMapper.feedback(uid, content, String.valueOf(System.currentTimeMillis()));
    }
}
