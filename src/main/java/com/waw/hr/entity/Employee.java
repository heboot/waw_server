package com.waw.hr.entity;

import com.waw.hr.core.MValue;
import com.waw.hr.model.EmployeeModel;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "tb_emplpyee")
public class Employee extends EmployeeModel {


    private String createTime;


    private Integer parentId;


    private String idCardPicFace;

    private String idCardPic;

//    private String bankCardFront;

//    private String bankCardReverse;


    @Transient
    private AdminUser parentUser;

    @Transient
    private AdminUser brokerUser;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIdCardPicFace() {
        if (StringUtils.isEmpty(idCardPicFace)) {
            return idCardPicFace;
        }
        return MValue.IMAGE_PRIFIX + idCardPicFace;
    }

    public void setIdCardPicFace(String idCardPicFace) {
        this.idCardPicFace = idCardPicFace;
    }

    public String getIdCardPic() {
        if (StringUtils.isEmpty(idCardPic)) {
            return idCardPic;
        }
        return MValue.IMAGE_PRIFIX + idCardPic;
    }

    public void setIdCardPic(String idCardPic) {
        this.idCardPic = idCardPic;
    }

    public AdminUser getParentUser() {
        return parentUser;
    }

    public void setParentUser(AdminUser parentUser) {
        this.parentUser = parentUser;
    }

    public AdminUser getBrokerUser() {
        return brokerUser;
    }

    public void setBrokerUser(AdminUser brokerUser) {
        this.brokerUser = brokerUser;
    }
}
