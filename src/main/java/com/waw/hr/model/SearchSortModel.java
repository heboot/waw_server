package com.waw.hr.model;

public class SearchSortModel {

    private String title;

    private Integer sort;

    public SearchSortModel(String title, Integer sort) {
        this.title = title;
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
