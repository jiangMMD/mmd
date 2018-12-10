package com.mmd.model;


public class Shopcat {

  private Long catId;
  private Long uid;
  private Double rmbmoney;
  private Double mmdmoney;
  private String username;

  public Long getCatId() {
    return catId;
  }

  public void setCatId(Long catId) {
    this.catId = catId;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public Double getRmbmoney() {
    return rmbmoney;
  }

  public void setRmbmoney(Double rmbmoney) {
    this.rmbmoney = rmbmoney;
  }

  public Double getMmdmoney() {
    return mmdmoney;
  }

  public void setMmdmoney(Double mmdmoney) {
    this.mmdmoney = mmdmoney;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
