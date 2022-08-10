package com.heu.his.pojo;


public class Drugs {

  private long id;
  private String drugsCode;
  private String drugsName;
  private String drugsFormat;
  private String drugsUnit;
  private String manufacturer;
  private long drugsDosageId;
  private long drugsTypeId;
  private double drugsPrice;
  private String mnemonicCode;
  private java.sql.Timestamp creationDate;
  private java.sql.Timestamp lastUpdateDate;
  private long delMark;

  private long amount;

  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }


  @Override
  public String toString() {
    return "Drugs{" +
            "id=" + id +
            ", drugsCode='" + drugsCode + '\'' +
            ", drugsName='" + drugsName + '\'' +
            ", drugsFormat='" + drugsFormat + '\'' +
            ", drugsUnit='" + drugsUnit + '\'' +
            ", manufacturer='" + manufacturer + '\'' +
            ", drugsDosageId=" + drugsDosageId +
            ", drugsTypeId=" + drugsTypeId +
            ", drugsPrice=" + drugsPrice +
            ", mnemonicCode='" + mnemonicCode + '\'' +
            ", creationDate=" + creationDate +
            ", lastUpdateDate=" + lastUpdateDate +
            ", delMark=" + delMark +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDrugsCode() {
    return drugsCode;
  }

  public void setDrugsCode(String drugsCode) {
    this.drugsCode = drugsCode;
  }


  public String getDrugsName() {
    return drugsName;
  }

  public void setDrugsName(String drugsName) {
    this.drugsName = drugsName;
  }


  public String getDrugsFormat() {
    return drugsFormat;
  }

  public void setDrugsFormat(String drugsFormat) {
    this.drugsFormat = drugsFormat;
  }


  public String getDrugsUnit() {
    return drugsUnit;
  }

  public void setDrugsUnit(String drugsUnit) {
    this.drugsUnit = drugsUnit;
  }


  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }


  public long getDrugsDosageId() {
    return drugsDosageId;
  }

  public void setDrugsDosageId(long drugsDosageId) {
    this.drugsDosageId = drugsDosageId;
  }


  public long getDrugsTypeId() {
    return drugsTypeId;
  }

  public void setDrugsTypeId(long drugsTypeId) {
    this.drugsTypeId = drugsTypeId;
  }


  public double getDrugsPrice() {
    return drugsPrice;
  }

  public void setDrugsPrice(double drugsPrice) {
    this.drugsPrice = drugsPrice;
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


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

}
