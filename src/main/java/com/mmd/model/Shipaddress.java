package com.mmd.model;


import java.io.Serializable;
import java.util.Date;

public class Shipaddress implements Serializable {

  private Long id;
  private Long uid;
  private String deliveryName;
  private String deliveryPhone;
  private String deliveryAddress;
  private String isdefault;
  private String zipcode;
  private String province;
  private String city;
  private String districtn;
  private String street;
  private String crtuser;
  private Date date;
  private Date update;
  private String upduser;
  private String recsts;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public String getDeliveryName() {
    return deliveryName;
  }

  public void setDeliveryName(String deliveryName) {
    this.deliveryName = deliveryName;
  }

  public String getDeliveryPhone() {
    return deliveryPhone;
  }

  public void setDeliveryPhone(String deliveryPhone) {
    this.deliveryPhone = deliveryPhone;
  }

  public String getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  public String getIsdefault() {
    return isdefault;
  }

  public void setIsdefault(String isdefault) {
    this.isdefault = isdefault;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getDistrictn() {
    return districtn;
  }

  public void setDistrictn(String districtn) {
    this.districtn = districtn;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCrtuser() {
    return crtuser;
  }

  public void setCrtuser(String crtuser) {
    this.crtuser = crtuser;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Date getUpdate() {
    return update;
  }

  public void setUpdate(Date update) {
    this.update = update;
  }

  public String getUpduser() {
    return upduser;
  }

  public void setUpduser(String upduser) {
    this.upduser = upduser;
  }

  public String getRecsts() {
    return recsts;
  }

  public void setRecsts(String recsts) {
    this.recsts = recsts;
  }
}
