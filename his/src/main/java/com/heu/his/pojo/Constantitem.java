package com.heu.his.pojo;


public class Constantitem {

  private long id;
  private long constantTypeId;
  private String constantCode;
  private String constantName;
  private long delMark;

  @Override
  public String toString() {
    return "Constantitem{" +
            "id=" + id +
            ", constantTypeId=" + constantTypeId +
            ", constantCode='" + constantCode + '\'' +
            ", constantName='" + constantName + '\'' +
            ", delMark=" + delMark +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getConstantTypeId() {
    return constantTypeId;
  }

  public void setConstantTypeId(long constantTypeId) {
    this.constantTypeId = constantTypeId;
  }


  public String getConstantCode() {
    return constantCode;
  }

  public void setConstantCode(String constantCode) {
    this.constantCode = constantCode;
  }


  public String getConstantName() {
    return constantName;
  }

  public void setConstantName(String constantName) {
    this.constantName = constantName;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

}
