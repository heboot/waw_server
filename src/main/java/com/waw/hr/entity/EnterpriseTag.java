package com.waw.hr.entity;

public class EnterpriseTag {

    private int id;

    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EnterpriseTag(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
