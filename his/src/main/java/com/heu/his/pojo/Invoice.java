package com.heu.his.pojo;


public class Invoice {

  private long id;
  private String invoiceNum;
  private double money;
  private long state;
  private java.sql.Timestamp creationTime;
  private long userId;
  private long registId;
  private long feeType;
  private String back;
  private long dailyState;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getInvoiceNum() {
    return invoiceNum;
  }

  public void setInvoiceNum(String invoiceNum) {
    this.invoiceNum = invoiceNum;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public java.sql.Timestamp getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(java.sql.Timestamp creationTime) {
    this.creationTime = creationTime;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getRegistId() {
    return registId;
  }

  public void setRegistId(long registId) {
    this.registId = registId;
  }


  public long getFeeType() {
    return feeType;
  }

  public void setFeeType(long feeType) {
    this.feeType = feeType;
  }


  public String getBack() {
    return back;
  }

  public void setBack(String back) {
    this.back = back;
  }


  public long getDailyState() {
    return dailyState;
  }

  public void setDailyState(long dailyState) {
    this.dailyState = dailyState;
  }

}
