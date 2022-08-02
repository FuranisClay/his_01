package com.heu.his.pojo;


public class Department {

  private long id;
  private String deptCode;
  private String deptName;
  private long deptCategoryId;
  private long deptType;
  private long delMark;

  @Override
  public String toString() {
    return "Department{" +
            "id=" + id +
            ", deptCode='" + deptCode + '\'' +
            ", deptName='" + deptName + '\'' +
            ", deptCategoryId=" + deptCategoryId +
            ", deptType=" + deptType +
            ", delMark=" + delMark +
            ", constantitem=" + constantitem +
            '}';
  }

  private Constantitem constantitem;

  public Constantitem getConstantitem() {
    return constantitem;
  }

  public void setConstantitem(Constantitem constantitem) {
    this.constantitem = constantitem;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDeptCode() {
    return deptCode;
  }

  public void setDeptCode(String deptCode) {
    this.deptCode = deptCode;
  }


  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }


  public long getDeptCategoryId() {
    return deptCategoryId;
  }

  public void setDeptCategoryId(long deptCategoryId) {
    this.deptCategoryId = deptCategoryId;
  }


  public long getDeptType() {
    return deptType;
  }

  public void setDeptType(long deptType) {
    this.deptType = deptType;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

}
