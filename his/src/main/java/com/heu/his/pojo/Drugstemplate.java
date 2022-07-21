package com.heu.his.pojo;


public class Drugstemplate {

  private long id;
  private String name;
  private long userId;
  private java.sql.Timestamp creationTime;
  private String scope;
  private long delMark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(java.sql.Timestamp creationTime) {
    this.creationTime = creationTime;
  }


  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }


  public long getDelMark() {
    return delMark;
  }

  public void setDelMark(long delMark) {
    this.delMark = delMark;
  }

}
