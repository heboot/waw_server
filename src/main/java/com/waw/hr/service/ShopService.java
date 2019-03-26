package com.waw.hr.service;

import com.waw.hr.entity.BankModel;
import com.waw.hr.entity.CityEntity;
import com.waw.hr.entity.ShopEntity;

import java.util.List;

public interface ShopService {

    List<ShopEntity> shopList();

    List<CityEntity> cityList();
}
