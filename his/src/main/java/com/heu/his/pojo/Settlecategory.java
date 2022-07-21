package com.heu.his.pojo;


public class Settlecategory {

  private long id;
  private String settleCode;
  private String settleName;
  private long sequenceNo;
  private long delMark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getSettleCode() {
    return settleCode;
  }

  public void setSettleCode(String settleCode) {
    this.settleCode = settleCode;
  }


  public String getSettleName() {
    return settleName;
  }

  public void setSettleName(String settleName) {
    this.settleName = settleName;
  }


  public long getSequenceNo() {
    return sequenceNo;
  }

  public void setSequenceNo(long sequenceNo) {
    this.sequenceNo = sequenceNo;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

}
