package com.heu.his.pojo;


public class Scheduling {

  private long id;
  private java.sql.Date schedDate;
  private long deptId;
  private long userId;
  private String noon;
  private long ruleId;
  private long delMark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public java.sql.Date getSchedDate() {
    return schedDate;
  }

  public void setSchedDate(java.sql.Date schedDate) {
    this.schedDate = schedDate;
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


  public String getNoon() {
    return noon;
  }

  public void setNoon(String noon) {
    this.noon = noon;
  }


  public long getRuleId() {
    return ruleId;
  }

  public void setRuleId(long ruleId) {
    this.ruleId = ruleId;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

}
