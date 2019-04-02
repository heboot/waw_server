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

    Integer addShop(@Param("name") String name, @Param("address") String address, @Param("lat") String lat, @Param("lng") String lng, @Param("brokerId") String brokerId, @Param("workTime") String workTime, @Param("type") int type, @Param("cityId") String cityId, @Param("createTime") String createTime);

}
