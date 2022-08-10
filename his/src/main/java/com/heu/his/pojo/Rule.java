package com.heu.his.pojo;


public class Rule {

  private long id;
  private String ruleName;
  private long deptId;
  private long userId;
  private String week;
  private long delMark;
  //部门
  private Department department;
  //用户
  private User user;

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getRuleName() {
    return ruleName;
  }

  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getWeek() {
    return week;
  }

  public void setWeek(String week) {
    this.week = week;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

  @Override
  public String toString() {
    return "Rule{" +
            "id=" + id +
            ", ruleName='" + ruleName + '\'' +
            ", deptId=" + deptId +
            ", userId=" + userId +
            ", week='" + week + '\'' +
            ", delMark=" + delMark +
            ", department=" + department +
            ", user=" + user +
            '}';
  }
}
