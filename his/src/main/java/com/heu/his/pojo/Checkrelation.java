package com.heu.his.pojo;


public class Checkrelation {

  private long id;
  private long checkProjId;
  private long checkTempId;
  private String position;

  @Override
  public String toString() {
    return "Checkrelation{" +
            "id=" + id +
            ", checkProjId=" + checkProjId +
            ", checkTempId=" + checkTempId +
            ", position='" + position + '\'' +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCheckProjId() {
    return checkProjId;
  }

  public void setCheckProjId(long checkProjId) {
    this.checkProjId = checkProjId;
  }


  public long getCheckTempId() {
    return checkTempId;
  }

  public void setCheckTempId(long checkTempId) {
    this.checkTempId = checkTempId;
  }


  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

}
