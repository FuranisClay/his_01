package com.heu.his.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Patientcosts {

  private long id;
  private long registId;
  private long invoiceId;
  private long itemId;
  private long itemType;
  private String name;
  private double price;
  private double amount;
  private long deptId;
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  private java.sql.Timestamp createtime;
  private long createOperId;
  private java.sql.Timestamp payTime;
  private long registerId;
  private long feeType;
  private long backId;

  @Override
  public String toString() {
    return "Patientcosts{" +
            "id=" + id +
            ", registId=" + registId +
            ", invoiceId=" + invoiceId +
            ", itemId=" + itemId +
            ", itemType=" + itemType +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", amount=" + amount +
            ", deptId=" + deptId +
            ", createtime=" + createtime +
            ", createOperId=" + createOperId +
            ", payTime=" + payTime +
            ", registerId=" + registerId +
            ", feeType=" + feeType +
            ", backId=" + backId +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getRegistId() {
    return registId;
  }

  public void setRegistId(long registId) {
    this.registId = registId;
  }


  public long getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(long invoiceId) {
    this.invoiceId = invoiceId;
  }


  public long getItemId() {
    return itemId;
  }

  public void setItemId(long itemId) {
    this.itemId = itemId;
  }


  public long getItemType() {
    return itemType;
  }

  public void setItemType(long itemType) {
    this.itemType = itemType;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public long getCreateOperId() {
    return createOperId;
  }

  public void setCreateOperId(long createOperId) {
    this.createOperId = createOperId;
  }


  public java.sql.Timestamp getPayTime() {
    return payTime;
  }

  public void setPayTime(java.sql.Timestamp payTime) {
    this.payTime = payTime;
  }


  public long getRegisterId() {
    return registerId;
  }

  public void setRegisterId(long registerId) {
    this.registerId = registerId;
  }


  public long getFeeType() {
    return feeType;
  }

  public void setFeeType(long feeType) {
    this.feeType = feeType;
  }


  public long getBackId() {
    return backId;
  }

  public void setBackId(long backId) {
    this.backId = backId;
  }

}
