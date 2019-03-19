package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.Banner;

import java.util.List;

public interface IndexMapper extends Mapper<Banner> {

    List<Banner> bannerList();

}
