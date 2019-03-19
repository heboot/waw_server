package com.waw.hr.entity;

import com.waw.hr.core.MValue;

import javax.persistence.Table;

@Table(name = "tb_banner")
public class Banner {

    private int id;

    private String background;

    private String icon;

    private String title;

    private String subTitle;

    private String enterpriseId;

    private String url;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBackground() {
        return MValue.IMAGE_PRIFIX + background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getIcon() {
        return MValue.IMAGE_PRIFIX + icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
