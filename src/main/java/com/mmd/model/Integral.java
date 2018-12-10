package com.mmd.model;


public class Integral {

  private Long id;
  private Long uid;
  private String type;
  private String backform;
  private Double value;
  private String state;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getBackform() {
    return backform;
  }

  public void setBackform(String backform) {
    this.backform = backform;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }
}
