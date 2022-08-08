package com.heu.his.pojo;


public class Sex {

  private long id;
  private String sex;

  @Override
  public String toString() {
    return "Sex{" +
            "id=" + id +
            ", sex='" + sex + '\'' +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

}
