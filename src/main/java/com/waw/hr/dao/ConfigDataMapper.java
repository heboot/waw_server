package com.waw.hr.dao;

import com.waw.hr.core.Mapper;
import com.waw.hr.entity.BankModel;
import com.waw.hr.entity.Banner;

import java.util.List;

public interface ConfigDataMapper extends Mapper<BankModel> {

    List<BankModel> bankList();

}
