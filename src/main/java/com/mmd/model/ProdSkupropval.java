package com.mmd.model;


public class ProdSkupropval {

  private Long pvId;
  private Long propId;
  private String propVal;
  private String propName;
  private Long propNameId;
  private String recsts;

  public Long getPvId() {
    return pvId;
  }

  public void setPvId(Long pvId) {
    this.pvId = pvId;
  }

  public Long getPropId() {
    return propId;
  }

  public void setPropId(Long propId) {
    this.propId = propId;
  }

  public String getPropVal() {
    return propVal;
  }

  public void setPropVal(String propVal) {
    this.propVal = propVal;
  }

  public String getPropName() {
    return propName;
  }

  public void setPropName(String propName) {
    this.propName = propName;
  }

  public Long getPropNameId() {
    return propNameId;
  }

  public void setPropNameId(Long propNameId) {
    this.propNameId = propNameId;
  }

  public String getRecsts() {
    return recsts;
  }

  public void setRecsts(String recsts) {
    this.recsts = recsts;
  }
}
