package com.heu.his.pojo;


public class Herbaltempdetailed {

  private long id;
  private long herbalTempId;
  private long herbalId;
  private String dosage;
  private String unit;
  private String footnote;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getHerbalTempId() {
    return herbalTempId;
  }

  public void setHerbalTempId(long herbalTempId) {
    this.herbalTempId = herbalTempId;
  }


  public long getHerbalId() {
    return herbalId;
  }

  public void setHerbalId(long herbalId) {
    this.herbalId = herbalId;
  }


  public String getDosage() {
    return dosage;
  }

  public void setDosage(String dosage) {
    this.dosage = dosage;
  }


  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }


  public String getFootnote() {
    return footnote;
  }

  public void setFootnote(String footnote) {
    this.footnote = footnote;
  }

}
