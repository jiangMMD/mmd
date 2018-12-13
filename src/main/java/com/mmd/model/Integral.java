package com.mmd.model;


import java.io.Serializable;

public class Integral implements Serializable {

  private Long id;
  private String type;
  private String backform;
  private Long value;
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

  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
