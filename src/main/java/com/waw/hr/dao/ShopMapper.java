package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.CityEntity;
import com.waw.hr.entity.FeedBackEntity;
import com.waw.hr.entity.ShopEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopMapper extends Mapper<ShopEntity> {

    List<ShopEntity> shopList();

    List<CityEntity> cityList();

}
