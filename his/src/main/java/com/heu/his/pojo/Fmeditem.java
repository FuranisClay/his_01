package com.heu.his.pojo;


public class Fmeditem {

  private long id;
  private String itemCode;
  private String itemName;
  private String format;
  private double price;
  private long expClassId;
  private long deptId;
  private String mnemonicCode;
  private java.sql.Timestamp creationDate;
  private java.sql.Timestamp lastUpdateDate;
  private long recordType;
  private long delMark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getItemCode() {
    return itemCode;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }


  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }


  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public long getExpClassId() {
    return expClassId;
  }

  public void setExpClassId(long expClassId) {
    this.expClassId = expClassId;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }


  public String getMnemonicCode() {
    return mnemonicCode;
  }

  public void setMnemonicCode(String mnemonicCode) {
    this.mnemonicCode = mnemonicCode;
  }


  public java.sql.Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(java.sql.Timestamp creationDate) {
    this.creationDate = creationDate;
  }


  public java.sql.Timestamp getLastUpdateDate() {
    return lastUpdateDate;
  }

  public void setLastUpdateDate(java.sql.Timestamp lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }


  public long getRecordType() {
    return recordType;
  }

  public void setRecordType(long recordType) {
    this.recordType = recordType;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

}
