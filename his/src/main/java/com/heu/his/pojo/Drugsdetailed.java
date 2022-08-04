package com.heu.his.pojo;


public class Drugsdetailed {

  private long id;
  private long drugsTempId;
  private long drugsId;
  private String drugsUsage;
  private String dosage;
  private String frequency;




  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getDrugsTempId() {
    return drugsTempId;
  }

  public void setDrugsTempId(long drugsTempId) {
    this.drugsTempId = drugsTempId;
  }


  public long getDrugsId() {
    return drugsId;
  }

  public void setDrugsId(long drugsId) {
    this.drugsId = drugsId;
  }


  public String getDrugsUsage() {
    return drugsUsage;
  }

  public void setDrugsUsage(String drugsUsage) {
    this.drugsUsage = drugsUsage;
  }


  public String getDosage() {
    return dosage;
  }

  public void setDosage(String dosage) {
    this.dosage = dosage;
  }


  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

}
