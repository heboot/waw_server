package com.waw.hr.entity;

import javax.persistence.Table;

@Table(name = "tb_emplpyee")
public class Employee {

    private Integer id;

    private String name;

    private String mobile;

    private String create_time;

    private Integer broker_id;

    private String join_work_time;

    private int sex;

    private int age;

    private String id_card_pic_face;

    private String id_card_pic;

    public String getId_card_pic_face() {
        return id_card_pic_face;
    }

    public void setId_card_pic_face(String id_card_pic_face) {
        this.id_card_pic_face = id_card_pic_face;
    }

    public String getId_card_pic() {
        return id_card_pic;
    }

    public void setId_card_pic(String id_card_pic) {
        this.id_card_pic = id_card_pic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Integer getBroker_id() {
        return broker_id;
    }

    public void setBroker_id(Integer broker_id) {
        this.broker_id = broker_id;
    }

    public String getJoin_work_time() {
        return join_work_time;
    }

    public void setJoin_work_time(String join_work_time) {
        this.join_work_time = join_work_time;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
