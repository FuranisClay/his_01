package com.heu.his.pojo;


public class Registlevel {

  private long id;
  private String registCode;
  private String registName;
  private long sequenceNo;
  private double registFee;
  private long registQuota;
  private long delMark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getRegistCode() {
    return registCode;
  }

  public void setRegistCode(String registCode) {
    this.registCode = registCode;
  }


  public String getRegistName() {
    return registName;
  }

  public void setRegistName(String registName) {
    this.registName = registName;
  }


  public long getSequenceNo() {
    return sequenceNo;
  }

  public void setSequenceNo(long sequenceNo) {
    this.sequenceNo = sequenceNo;
  }


  public double getRegistFee() {
    return registFee;
  }

  public void setRegistFee(double registFee) {
    this.registFee = registFee;
  }


  public long getRegistQuota() {
    return registQuota;
  }

  public void setRegistQuota(long registQuota) {
    this.registQuota = registQuota;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

}
