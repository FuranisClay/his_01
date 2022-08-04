package com.heu.his.pojo;


import java.util.List;

public class Register {

  private long id;
  private String caseNumber;
  private String realName;
  private String gender;
  private String iDnumber;
  private String birthDate;
  private long age;
  private String ageType;
  private String homeAddress;
  private String visitDate;
  private String noon;
  private long deptId;
  private long userId;
  private long registLeId;
  private long settleId;
  private String isBook;
  private String registTime;
  private long registerId;
  private long visitState;
  private long phoneNumber;


  //  改患者的挂号编号的信息
  private Registlevel registlevel;

  public Registlevel getRegistlevel() {
    return registlevel;
  }

  public void setRegistlevel(Registlevel registlevel) {
    this.registlevel = registlevel;
  }

  //改患者的挂号医生的显示
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  //查询患者的项目
  private List<Patientcosts> patientcosts;

  public List<Patientcosts> getPatientcosts() {
    return patientcosts;
  }

  public void setPatientcosts(List<Patientcosts> patientcosts) {
    this.patientcosts = patientcosts;
  }

  //显示患者挂号科室
  public List<Department> departments;

  public List<Department> getDepartments() {
    return departments;
  }

  public void setDepartments(List<Department> departments) {
    this.departments = departments;
  }

  //显示患者的付费方式
  public  List<Settlecategory> settlecategory;

  public List<Settlecategory> getSettlecategory() {
    return settlecategory;
  }

  public void setSettlecategory(List<Settlecategory> settlecategory) {
    this.settlecategory = settlecategory;
  }






  @Override
  public String toString() {
    return "Register{" +
            "id=" + id +
            ", caseNumber='" + caseNumber + '\'' +
            ", realName='" + realName + '\'' +
            ", gender=" + gender +
            ", iDnumber='" + iDnumber + '\'' +
            ", birthDate=" + birthDate +
            ", age=" + age +
            ", ageType='" + ageType + '\'' +
            ", homeAddress='" + homeAddress + '\'' +
            ", visitDate=" + visitDate +
            ", noon='" + noon + '\'' +
            ", deptId=" + deptId +
            ", userId=" + userId +
            ", registLeId=" + registLeId +
            ", settleId=" + settleId +
            ", isBook='" + isBook + '\'' +
            ", registTime=" + registTime +
            ", registerId=" + registerId +
            ", visitState=" + visitState +
            ", phoneNumber=" + phoneNumber +
            ", registlevel=" + registlevel +
            ", doctor=" + user +
            ", patientcosts=" + patientcosts +
            '}';
  }


  public long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCaseNumber() {
    return caseNumber;
  }

  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
  }


  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getIDnumber() {
    return iDnumber;
  }

  public void setIDnumber(String iDnumber) {
    this.iDnumber = iDnumber;
  }


  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getAgeType() {
    return ageType;
  }

  public void setAgeType(String ageType) {
    this.ageType = ageType;
  }


  public String getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
  }


  public String getVisitDate() {
    return visitDate;
  }

  public void setVisitDate(String visitDate) {
    this.visitDate = visitDate;
  }


  public String getNoon() {
    return noon;
  }

  public void setNoon(String noon) {
    this.noon = noon;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getRegistLeId() {
    return registLeId;
  }

  public void setRegistLeId(long registLeId) {
    this.registLeId = registLeId;
  }


  public long getSettleId() {
    return settleId;
  }

  public void setSettleId(long settleId) {
    this.settleId = settleId;
  }


  public String getIsBook() {
    return isBook;
  }

  public void setIsBook(String isBook) {
    this.isBook = isBook;
  }


  public String getRegistTime() {
    return registTime;
  }

  public void setRegistTime(String registTime) {
    this.registTime = registTime;
  }


  public long getRegisterId() {
    return registerId;
  }

  public void setRegisterId(long registerId) {
    this.registerId = registerId;
  }


  public long getVisitState() {
    return visitState;
  }

  public void setVisitState(long visitState) {
    this.visitState = visitState;
  }

}
