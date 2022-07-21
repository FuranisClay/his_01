package com.heu.his.pojo;

public class Prescriptiondetailed {

  private long id;
  private long prescriptionId;
  private long drugsId;
  private String drugsUsage;
  private String dosage;
  private String frequency;
  private double amount;
  private long state;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPrescriptionId() {
    return prescriptionId;
  }

  public void setPrescriptionId(long prescriptionId) {
    this.prescriptionId = prescriptionId;
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


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }

}
