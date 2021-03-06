package com.waw.hr.entity;

import com.waw.hr.model.EnterpriseListModel;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 企业类Enterprise
 */
@Table(name = "tb_enterprise")
public class Enterprise extends EnterpriseListModel {

    /**
     * 无参构造
     */
    public Enterprise() {
    }

//    /**
//     * 有参构造
//     */
//    public Enterprise(Integer id, String name, String salary, String salaryDate, String salaryBasic,
//                      String salaryInfo, String eatInfo, String dormInfo,
//                      String trafficInfo, String age, String icon,
//                      String tip, String info, String contractualInfo,
//                      String contractualSalary, String contractualInsurance, String jobContent,
//                      String jobInfo, String jobEnvironment, String physicalInfo,
//                      String idCardInfo, String diplomaInfo, String photoInfo,
//                      String employIdCardInfo, String employDiplomaInfo, String employSexAgeInfo,
//                      String employTattoo, String employSmoke, String employReturnInfo,
//                      String employEnglish, String employArithmetic, String employFace,
//                      String employClearGarment, String employPhysical, String employForeign,
//                      String address, String lat, String lng, Date gmtCreate, Date gmtModified, Integer status) {
//        this.id = id;
//        this.name = name;
//        this.salary = salary;
//        this.salaryDate = salaryDate;
//        this.salaryBasic = salaryBasic;
//        this.salaryInfo = salaryInfo;
//        this.eatInfo = eatInfo;
//        this.dormInfo = dormInfo;
//        this.trafficInfo = trafficInfo;
//        this.age = age;
//        this.icon = icon;
//        this.tip = tip;
//        this.info = info;
//        this.contractualInfo = contractualInfo;
//        this.contractualSalary = contractualSalary;
//        this.contractualInsurance = contractualInsurance;
//        this.jobContent = jobContent;
//        this.jobInfo = jobInfo;
//        this.jobEnvironment = jobEnvironment;
//        this.physicalInfo = physicalInfo;
//        this.idCardInfo = idCardInfo;
//        this.diplomaInfo = diplomaInfo;
//        this.photoInfo = photoInfo;
//        this.employIdCardInfo = employIdCardInfo;
//        this.employDiplomaInfo = employDiplomaInfo;
//        this.employSexAgeInfo = employSexAgeInfo;
//        this.employTattoo = employTattoo;
//        this.employSmoke = employSmoke;
//        this.employReturnInfo = employReturnInfo;
//        this.employEnglish = employEnglish;
//        this.employArithmetic = employArithmetic;
//        this.employFace = employFace;
//        this.employClearGarment = employClearGarment;
//        this.employPhysical = employPhysical;
//        this.employForeign = employForeign;
//        this.address = address;
//        this.lat = lat;
//        this.lng = lng;
//        this.gmtCreate = gmtCreate;
//        this.gmtModified = gmtModified;
//        this.status = status;
//    }


//    //主键
//    private Integer id;
//
//    //企业名称
//    private String name;
//
//    //综合薪资 比如3000-4500元
//    private String salary;

    //发薪日 比如 每月5日
    private String salaryDate;

    //底薪 比如2020元/月
    private String salaryBasic;

    //薪资介绍 比如 加班费 1940元计算，1.5倍 2倍
    private String salaryInfo;

    //伙食信息 比如 伙食费70元每月 从工资扣除
    private String eatInfo;

    //住宿信息
    private String dormInfo;

    //交通信息 比如交通补贴之类的
    private String trafficInfo;

    //年龄要求 比如男：19-35岁 女18-40岁
    private String age;

    //小图标
    private String icon;

    //温馨提示
    private String tip;

    //企业信息
    private String info;

    //合同说明
    private String contractualInfo;

    //合同中关于工资发发放的说明
    private String contractualSalary;

    //合同中关于保险部分的说明
    private String contractualInsurance;

    //工作内容
    private String jobContent;

    //工作说明
    private String jobInfo;

    //工作环境
    private String jobEnvironment;

    //体检说明
    private String physicalInfo;

    //身份证说明
    private String idCardInfo;

    //毕业证说明
    private String diplomaInfo;

    //照片说明
    private String photoInfo;

    //录用条件-身份证说明
    private String employIdCardInfo;

    //录用条件-毕业证说明
    private String employDiplomaInfo;

    //性别年龄信息
    private String employSexAgeInfo;

    //纹身
    private String employTattoo;

    //抽烟
    private String employSmoke;

    //返厂规定
    private String employReturnInfo;

    //英文水平
    private String employEnglish;

    //数学水平
    private String employArithmetic;

    //人脸识别说明em
    private String employFace;

    //无尘服要求
    private String employClearGarment;

    //体检说明
    private String employPhysical;

    //体内异物说明
    private String employForeign;

    //企业地址
    private String address;

    //企业地址纬度
    private String lat;

    //企业地址经度
    private String lng;

    //必备字段
    private String gmtCreate;
    private String gmtModified;
    private Integer status;


    //企业补贴金额
//    private Integer subsidyMoney;

    //企业补贴说明
    private String subsidyInfo;

    //打包给渠道商的价格 不再使用
    private String packageMoney;


    //本地字段
    @Transient
    private int isFollow;

    @Transient
    private int isJoin;

    public String getPackageMoney() {
        return packageMoney;
    }

    public void setPackageMoney(String packageMoney) {
        this.packageMoney = packageMoney;
    }

    public int getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(int isFollow) {
        this.isFollow = isFollow;
    }

    public int getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(int isJoin) {
        this.isJoin = isJoin;
    }

    public String getSubsidyInfo() {
        return subsidyInfo;
    }

    public void setSubsidyInfo(String subsidyInfo) {
        this.subsidyInfo = subsidyInfo;
    }

    public String getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(String salaryDate) {
        this.salaryDate = salaryDate;
    }

    public String getSalaryBasic() {
        return salaryBasic;
    }

    public void setSalaryBasic(String salaryBasic) {
        this.salaryBasic = salaryBasic;
    }

    public String getSalaryInfo() {
        return salaryInfo;
    }

    public void setSalaryInfo(String salaryInfo) {
        this.salaryInfo = salaryInfo;
    }

    public String getEatInfo() {
        return eatInfo;
    }

    public void setEatInfo(String eatInfo) {
        this.eatInfo = eatInfo;
    }

    public String getDormInfo() {
        return dormInfo;
    }

    public void setDormInfo(String dormInfo) {
        this.dormInfo = dormInfo;
    }

    public String getTrafficInfo() {
        return trafficInfo;
    }

    public void setTrafficInfo(String trafficInfo) {
        this.trafficInfo = trafficInfo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getContractualInfo() {
        return contractualInfo;
    }

    public void setContractualInfo(String contractualInfo) {
        this.contractualInfo = contractualInfo;
    }

    public String getContractualSalary() {
        return contractualSalary;
    }

    public void setContractualSalary(String contractualSalary) {
        this.contractualSalary = contractualSalary;
    }

    public String getContractualInsurance() {
        return contractualInsurance;
    }

    public void setContractualInsurance(String contractualInsurance) {
        this.contractualInsurance = contractualInsurance;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(String jobInfo) {
        this.jobInfo = jobInfo;
    }

    public String getJobEnvironment() {
        return jobEnvironment;
    }

    public void setJobEnvironment(String jobEnvironment) {
        this.jobEnvironment = jobEnvironment;
    }

    public String getPhysicalInfo() {
        return physicalInfo;
    }

    public void setPhysicalInfo(String physicalInfo) {
        this.physicalInfo = physicalInfo;
    }

    public String getIdCardInfo() {
        return idCardInfo;
    }

    public void setIdCardInfo(String idCardInfo) {
        this.idCardInfo = idCardInfo;
    }

    public String getDiplomaInfo() {
        return diplomaInfo;
    }

    public void setDiplomaInfo(String diplomaInfo) {
        this.diplomaInfo = diplomaInfo;
    }

    public String getPhotoInfo() {
        return photoInfo;
    }

    public void setPhotoInfo(String photoInfo) {
        this.photoInfo = photoInfo;
    }

    public String getEmployIdCardInfo() {
        return employIdCardInfo;
    }

    public void setEmployIdCardInfo(String employIdCardInfo) {
        this.employIdCardInfo = employIdCardInfo;
    }

    public String getEmployDiplomaInfo() {
        return employDiplomaInfo;
    }

    public void setEmployDiplomaInfo(String employDiplomaInfo) {
        this.employDiplomaInfo = employDiplomaInfo;
    }

    public String getEmploySexAgeInfo() {
        return employSexAgeInfo;
    }

    public void setEmploySexAgeInfo(String employSexAgeInfo) {
        this.employSexAgeInfo = employSexAgeInfo;
    }

    public String getEmployTattoo() {
        return employTattoo;
    }

    public void setEmployTattoo(String employTattoo) {
        this.employTattoo = employTattoo;
    }

    public String getEmploySmoke() {
        return employSmoke;
    }

    public void setEmploySmoke(String employSmoke) {
        this.employSmoke = employSmoke;
    }

    public String getEmployReturnInfo() {
        return employReturnInfo;
    }

    public void setEmployReturnInfo(String employReturnInfo) {
        this.employReturnInfo = employReturnInfo;
    }

    public String getEmployEnglish() {
        return employEnglish;
    }

    public void setEmployEnglish(String employEnglish) {
        this.employEnglish = employEnglish;
    }

    public String getEmployArithmetic() {
        return employArithmetic;
    }

    public void setEmployArithmetic(String employArithmetic) {
        this.employArithmetic = employArithmetic;
    }

    public String getEmployFace() {
        return employFace;
    }

    public void setEmployFace(String employFace) {
        this.employFace = employFace;
    }

    public String getEmployClearGarment() {
        return employClearGarment;
    }

    public void setEmployClearGarment(String employClearGarment) {
        this.employClearGarment = employClearGarment;
    }

    public String getEmployPhysical() {
        return employPhysical;
    }

    public void setEmployPhysical(String employPhysical) {
        this.employPhysical = employPhysical;
    }

    public String getEmployForeign() {
        return employForeign;
    }

    public void setEmployForeign(String employForeign) {
        this.employForeign = employForeign;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
