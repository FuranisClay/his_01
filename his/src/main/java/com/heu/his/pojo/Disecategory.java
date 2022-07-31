package com.heu.his.pojo;


public class Disecategory {

  private long id;
  private String dicaCode;
  private String dicaName;
  private long sequenceNo;
  private long dicaType;
  private long delMark;

  @Override
  public String toString() {
    return "Disecategory{" +
            "id=" + id +
            ", dicaCode='" + dicaCode + '\'' +
            ", dicaName='" + dicaName + '\'' +
            ", sequenceNo=" + sequenceNo +
            ", dicaType=" + dicaType +
            ", delMark=" + delMark +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDicaCode() {
    return dicaCode;
  }

  public void setDicaCode(String dicaCode) {
    this.dicaCode = dicaCode;
  }


  public String getDicaName() {
    return dicaName;
  }

  public void setDicaName(String dicaName) {
    this.dicaName = dicaName;
  }


  public long getSequenceNo() {
    return sequenceNo;
  }

  public void setSequenceNo(long sequenceNo) {
    this.sequenceNo = sequenceNo;
  }


  public long getDicaType() {
    return dicaType;
  }

  public void setDicaType(long dicaType) {
    this.dicaType = dicaType;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

}
