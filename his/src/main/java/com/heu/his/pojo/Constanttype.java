package com.heu.his.pojo;


public class Constanttype {

  private long id;
  private String constantTypeCode;
  private String constantTypeName;
  private long delMark;

  @Override
  public String toString() {
    return "Constanttype{" +
            "id=" + id +
            ", constantTypeCode='" + constantTypeCode + '\'' +
            ", constantTypeName='" + constantTypeName + '\'' +
            ", delMark=" + delMark +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getConstantTypeCode() {
    return constantTypeCode;
  }

  public void setConstantTypeCode(String constantTypeCode) {
    this.constantTypeCode = constantTypeCode;
  }


  public String getConstantTypeName() {
    return constantTypeName;
  }

  public void setConstantTypeName(String constantTypeName) {
    this.constantTypeName = constantTypeName;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

}
