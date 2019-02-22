package com.waw.hr.response;

import java.util.List;

public class PreSearchListResponse extends BaseResponse {

    private List<String> hotTagList;

    private List<String> hotEnterpriseList;

    private List<String> hotCityList;


    public List<String> getHotCityList() {
        return hotCityList;
    }

    public void setHotCityList(List<String> hotCityList) {
        this.hotCityList = hotCityList;
    }

    public PreSearchListResponse(List<String> hotTagList, List<String> hotEnterpriseList, List<String> hotCityList) {
        this.hotTagList = hotTagList;
        this.hotEnterpriseList = hotEnterpriseList;
        this.hotCityList = hotCityList;
    }

    public List<String> getHotTagList() {
        return hotTagList;
    }

    public void setHotTagList(List<String> hotTagList) {
        this.hotTagList = hotTagList;
    }

    public List<String> getHotEnterpriseList() {
        return hotEnterpriseList;
    }

    public void setHotEnterpriseList(List<String> hotEnterpriseList) {
        this.hotEnterpriseList = hotEnterpriseList;
    }
}
