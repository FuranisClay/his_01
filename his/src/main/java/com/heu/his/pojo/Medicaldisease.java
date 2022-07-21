package com.heu.his.pojo;


public class Medicaldisease {

  private long id;
  private long medicalId;
  private long registId;
  private long diseaseId;
  private long diagnoseType;
  private java.sql.Timestamp getSiskDate;
  private long diagnoseCate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getMedicalId() {
    return medicalId;
  }

  public void setMedicalId(long medicalId) {
    this.medicalId = medicalId;
  }


  public long getRegistId() {
    return registId;
  }

  public void setRegistId(long registId) {
    this.registId = registId;
  }


  public long getDiseaseId() {
    return diseaseId;
  }

  public void setDiseaseId(long diseaseId) {
    this.diseaseId = diseaseId;
  }


  public long getDiagnoseType() {
    return diagnoseType;
  }

  public void setDiagnoseType(long diagnoseType) {
    this.diagnoseType = diagnoseType;
  }


  public java.sql.Timestamp getGetSiskDate() {
    return getSiskDate;
  }

  public void setGetSiskDate(java.sql.Timestamp getSiskDate) {
    this.getSiskDate = getSiskDate;
  }


  public long getDiagnoseCate() {
    return diagnoseCate;
  }

  public void setDiagnoseCate(long diagnoseCate) {
    this.diagnoseCate = diagnoseCate;
  }

}
