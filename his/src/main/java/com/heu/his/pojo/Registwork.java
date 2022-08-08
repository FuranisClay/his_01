package com.heu.his.pojo;


public class Registwork {

  private long id;
  private long registerId;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getRegisterId() {
    return registerId;
  }

  public void setRegisterId(long registerId) {
    this.registerId = registerId;
  }


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }


  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }

}
