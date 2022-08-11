package com.heu.his.pojo;

import java.util.List;

import java.util.List;

public class Checkapply {

  private long id;
  private long medicalId;
  private long registId;
  private long itemId;
  private String name;
  private String objective;
  private String position;
  private long isUrgent;
  private long num;
  private java.sql.Timestamp creationTime;
  private long doctorId;
  private long checkOperId;
  private long resultOperId;
  private java.sql.Timestamp checkTime;
  private String result;
  private java.sql.Timestamp resultTime;
  private long state;
  private long recordType;

//  private java.util.List<Fmeditem> fmeditems;
//
//  public List<Fmeditem> getFmeditems() {
//    return fmeditems;
//  }
//
//  public void setFmeditems(List<Fmeditem> fmeditems) {
//    this.fmeditems = fmeditems;
//  }

  @Override
  public String toString() {
    return "Checkapply{" +
            "id=" + id +
            ", medicalId=" + medicalId +
            ", registId=" + registId +
            ", itemId=" + itemId +
            ", name='" + name + '\'' +
            ", objective='" + objective + '\'' +
            ", position='" + position + '\'' +
            ", isUrgent=" + isUrgent +
            ", num=" + num +
            ", creationTime=" + creationTime +
            ", doctorId=" + doctorId +
            ", checkOperId=" + checkOperId +
            ", resultOperId=" + resultOperId +
            ", checkTime=" + checkTime +
            ", result='" + result + '\'' +
            ", resultTime=" + resultTime +
            ", state=" + state +
            ", recordType=" + recordType +
            '}';
  }

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


  public long getItemId() {
    return itemId;
  }

  public void setItemId(long itemId) {
    this.itemId = itemId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getObjective() {
    return objective;
  }

  public void setObjective(String objective) {
    this.objective = objective;
  }


  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }


  public long getIsUrgent() {
    return isUrgent;
  }

  public void setIsUrgent(long isUrgent) {
    this.isUrgent = isUrgent;
  }


  public long getNum() {
    return num;
  }

  public void setNum(long num) {
    this.num = num;
  }


  public java.sql.Timestamp getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(java.sql.Timestamp creationTime) {
    this.creationTime = creationTime;
  }


  public long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(long doctorId) {
    this.doctorId = doctorId;
  }


  public long getCheckOperId() {
    return checkOperId;
  }

  public void setCheckOperId(long checkOperId) {
    this.checkOperId = checkOperId;
  }


  public long getResultOperId() {
    return resultOperId;
  }

  public void setResultOperId(long resultOperId) {
    this.resultOperId = resultOperId;
  }


  public java.sql.Timestamp getCheckTime() {
    return checkTime;
  }

  public void setCheckTime(java.sql.Timestamp checkTime) {
    this.checkTime = checkTime;
  }


  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }


  public java.sql.Timestamp getResultTime() {
    return resultTime;
  }

  public void setResultTime(java.sql.Timestamp resultTime) {
    this.resultTime = resultTime;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public long getRecordType() {
    return recordType;
  }

  public void setRecordType(long recordType) {
    this.recordType = recordType;
  }

}
