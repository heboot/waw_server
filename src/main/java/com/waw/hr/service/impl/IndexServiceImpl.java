package com.waw.hr.service.impl;

import com.waw.hr.dao.EmployeeSignLogMapper;
import com.waw.hr.dao.IndexMapper;
import com.waw.hr.entity.Banner;
import com.waw.hr.service.IndexService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class IndexServiceImpl implements IndexService {

    @Resource
    private IndexMapper indexMapper;

    @Override
    public List<Banner> bannerList() {
        return indexMapper.bannerList();
    }
}
