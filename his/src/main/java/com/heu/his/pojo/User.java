package com.heu.his.pojo;


import com.heu.his.pojo.Constantitem;
import com.heu.his.pojo.Department;
import com.heu.his.pojo.Registlevel;

public class User {

  private long id;
  private String userName;
  private String password;
  private String realName;
  private long useType;
  private long docTitleId;
  private String isScheduling;
  private long deptId;
  private long registLeId;
  private long delMark;

  //挂号级别
  private Registlevel registlevel;
  //医生职称
  private Constantitem constantitem;
  //部门信息
  private Department department;
  //排班规则
  private boolean[] rule = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false,false};

  public boolean[] getRule() {
    return rule;
  }

  public void setRule(boolean[] rule) {
    this.rule = rule;
  }

  public Registlevel getRegistlevel() {
    return registlevel;
  }

  public void setRegistlevel(Registlevel registlevel) {
    this.registlevel = registlevel;
  }

  public Constantitem getConstantitem() {
    return constantitem;
  }

  public void setConstantitem(Constantitem constantitem) {
    this.constantitem = constantitem;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }


  public long getUseType() {
    return useType;
  }

  public void setUseType(long useType) {
    this.useType = useType;
  }


  public long getDocTitleId() {
    return docTitleId;
  }

  public void setDocTitleId(long docTitleId) {
    this.docTitleId = docTitleId;
  }


  public String getIsScheduling() {
    return isScheduling;
  }

  public void setIsScheduling(String isScheduling) {
    this.isScheduling = isScheduling;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }


  public long getRegistLeId() {
    return registLeId;
  }

  public void setRegistLeId(long registLeId) {
    this.registLeId = registLeId;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", realName='" + realName + '\'' +
            ", useType=" + useType +
            ", docTitleId=" + docTitleId +
            ", isScheduling='" + isScheduling + '\'' +
            ", deptId=" + deptId +
            ", registLeId=" + registLeId +
            ", delMark=" + delMark +
            ", registlevel=" + registlevel +
            ", constantitem=" + constantitem +
            ", department=" + department +
            '}';
  }
}
