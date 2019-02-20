package com.waw.hr.response;

import java.util.List;

public class PreSearchListResponse extends BaseResponse {

    private List<String> hotTagList;

    private List<String> hotEnterpriseList;

    public PreSearchListResponse(List<String> hotTagList, List<String> hotEnterpriseList) {
        this.hotTagList = hotTagList;
        this.hotEnterpriseList = hotEnterpriseList;
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
