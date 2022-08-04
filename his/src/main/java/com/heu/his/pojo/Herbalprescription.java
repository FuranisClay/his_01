package com.heu.his.pojo;


public class Herbalprescription {

  private long id;
  private long medicalId;
  private long registId;
  private long userId;
  private String prescriptionName;
  private java.sql.Timestamp creationTime;
  private String prescriptioType;
  private long payNumber;
  private String frequency;
  private String drugsUsage;
  private String therapy;
  private String detailed;
  private String advice;
  private long state;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getMedicalId() {
    return medicalId;
  }

  public void setMedicalId(long medicalId) {
    this.medicalId = medicalId;
  }


  public long getRegistId() {
    return registId;
  }

  public void setRegistId(long registId) {
    this.registId = registId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getPrescriptionName() {
    return prescriptionName;
  }

  public void setPrescriptionName(String prescriptionName) {
    this.prescriptionName = prescriptionName;
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


  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
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


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }

}
