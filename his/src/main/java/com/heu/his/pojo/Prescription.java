package com.heu.his.pojo;


public class Prescription {

  private long id;
  private long medicalId;
  private long registId;
  private long userId;
  private String prescriptionName;
  private java.sql.Timestamp prescriptionTime;
  private long prescriptionState;


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


  public java.sql.Timestamp getPrescriptionTime() {
    return prescriptionTime;
  }

  public void setPrescriptionTime(java.sql.Timestamp prescriptionTime) {
    this.prescriptionTime = prescriptionTime;
  }


  public long getPrescriptionState() {
    return prescriptionState;
  }

  public void setPrescriptionState(long prescriptionState) {
    this.prescriptionState = prescriptionState;
  }

}
