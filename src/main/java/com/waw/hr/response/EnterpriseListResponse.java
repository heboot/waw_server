package com.waw.hr.response;

import com.waw.hr.entity.Banner;
import com.waw.hr.model.EnterpriseListModel;

import javax.persistence.Transient;
import java.util.List;

public class EnterpriseListResponse extends BaseListResponse {

    private List<EnterpriseListModel> list;

    public List<EnterpriseListModel> getList() {
        return list;
    }

    private List<Banner> banners;

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public void setList(List<EnterpriseListModel> list) {
        this.list = list;
    }

    public EnterpriseListResponse(int page, int size, int totalPage, List<EnterpriseListModel> list) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
    }

    public EnterpriseListResponse(int page, int size, int totalPage, List<EnterpriseListModel> list, List<Banner> banners, int total) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
        this.banners = banners;
        this.total = total;
    }

    public EnterpriseListResponse(int page, int size, int totalPage, List<EnterpriseListModel> list, int total) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.list = list;
        this.total = total;
    }
}
