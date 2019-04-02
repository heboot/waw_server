package com.waw.hr.service;

import com.waw.hr.entity.BankModel;
import com.waw.hr.entity.CityEntity;
import com.waw.hr.entity.ShopEntity;

import java.util.List;

public interface ShopService {

    List<ShopEntity> shopList();

    List<CityEntity> cityList();

    Integer addShop(String name, String address, String lat, String lng, String brokerId, String workTime, int type, String cityId);
}
