package com.mmd.model;


import java.util.List;
import java.util.Map;

public class ProdSkupropname {

  private Long propId;
  private String propName;
  private String recsts;
  private String propVal;
  private List<Map<String,Object>> propValList;


  public Long getPropId() {
    return propId;
  }

  public void setPropId(Long propId) {
    this.propId = propId;
  }

  public String getPropName() {
    return propName;
  }

  public void setPropName(String propName) {
    this.propName = propName;
  }

  public String getRecsts() {
    return recsts;
  }

  public void setRecsts(String recsts) {
    this.recsts = recsts;
  }

  public String getPropVal() {
    return propVal;
  }

  public void setPropVal(String propVal) {
    this.propVal = propVal;
  }

  public List<Map<String, Object>> getPropValList() {
    return propValList;
  }

  public void setPropValList(List<Map<String, Object>> propValList) {
    this.propValList = propValList;
  }
}
