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

    @Override
    public Integer addShop(String name, String address, String lat, String lng, String brokerId, String workTime, int type, String cityId) {
        return shopMapper.addShop(name, address, lat, lng, brokerId, workTime, type, cityId, String.valueOf(System.currentTimeMillis()));
    }
}
