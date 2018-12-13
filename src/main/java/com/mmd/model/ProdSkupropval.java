package com.mmd.model;


public class ProdSkupropval {

  private Long pvId;
  private Long propId;
  private String propVal;
  private Long propNameId;

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

  public Long getPropNameId() {
    return propNameId;
  }

  public void setPropNameId(Long propNameId) {
    this.propNameId = propNameId;
  }
}
