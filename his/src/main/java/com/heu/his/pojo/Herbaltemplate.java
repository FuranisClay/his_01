package com.heu.his.pojo;


public class Herbaltemplate {

  private long id;
  private String name;
  private long doctorId;
  private java.sql.Timestamp creationTime;
  private String prescriptioType;
  private long payNumber;
  private String drugsUsage;
  private String therapy;
  private String detailed;
  private String advice;
  private String scope;
  private long delMark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(long doctorId) {
    this.doctorId = doctorId;
  }


  public java.sql.Timestamp getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(java.sql.Timestamp creationTime) {
    this.creationTime = creationTime;
  }


  public String getPrescriptioType() {
    return prescriptioType;
  }

  public void setPrescriptioType(String prescriptioType) {
    this.prescriptioType = prescriptioType;
  }


  public long getPayNumber() {
    return payNumber;
  }

  public void setPayNumber(long payNumber) {
    this.payNumber = payNumber;
  }


  public String getDrugsUsage() {
    return drugsUsage;
  }

  public void setDrugsUsage(String drugsUsage) {
    this.drugsUsage = drugsUsage;
  }


  public String getTherapy() {
    return therapy;
  }

  public void setTherapy(String therapy) {
    this.therapy = therapy;
  }


  public String getDetailed() {
    return detailed;
  }

  public void setDetailed(String detailed) {
    this.detailed = detailed;
  }


  public String getAdvice() {
    return advice;
  }

  public void setAdvice(String advice) {
    this.advice = advice;
  }


  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

}
