package com.waw.hr.service.impl;

import com.waw.hr.dao.ShopMapper;
import com.waw.hr.entity.CityEntity;
import com.waw.hr.entity.ShopEntity;
import com.waw.hr.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    @Resource
    ShopMapper shopMapper;

    @Override
    public List<ShopEntity> shopList() {
        return shopMapper.shopList();
    }

    @Override
    public List<CityEntity> cityList() {
        return shopMapper.cityList();
    }
}
