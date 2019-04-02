package com.waw.hr.response;

import com.waw.hr.entity.CityEntity;

import java.util.List;

public class GetCityListResponse  {

    private List<CityEntity> list;

    public List<CityEntity> getList() {
        return list;
    }

    public void setList(List<CityEntity> list) {
        this.list = list;
    }

    public GetCityListResponse(List<CityEntity> list) {
        this.list = list;
    }
}
