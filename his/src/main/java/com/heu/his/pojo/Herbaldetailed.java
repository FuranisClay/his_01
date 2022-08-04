package com.heu.his.pojo;


public class Herbaldetailed {

  private long id;
  private long herbalPresId;
  private long herbalId;
  private String dosage;
  private double price;
  private String footnote;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getHerbalPresId() {
    return herbalPresId;
  }

  public void setHerbalPresId(long herbalPresId) {
    this.herbalPresId = herbalPresId;
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


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public String getFootnote() {
    return footnote;
  }

  public void setFootnote(String footnote) {
    this.footnote = footnote;
  }

}
