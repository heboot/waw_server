package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.FeedBackEntity;
import org.apache.ibatis.annotations.Param;

public interface CommonMapper extends Mapper<FeedBackEntity> {

    int feedback(@Param("uid") String uid, @Param("content") String content, @Param("time") String time);

}
