package com.heu.his.pojo;


public class Expenseclass {

  private long id;
  private String expCode;
  private String expName;
  private long delMark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getExpCode() {
    return expCode;
  }

  public void setExpCode(String expCode) {
    this.expCode = expCode;
  }


  public String getExpName() {
    return expName;
  }

  public void setExpName(String expName) {
    this.expName = expName;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

}
