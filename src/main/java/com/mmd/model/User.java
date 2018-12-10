package com.mmd.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {

  private Long uId;
  private String uName;
  private String uPhone;
  private String uNick;
  private String uSex;
  private Long uAge;
  private Long uIntegral; //用户剩余积分
  private String uPassword;
  private String uIdentity;
  private String uAddress; //用户家庭住址
  private String uMmdNo; //关联的MMD账户
  private String uMmdPassword; //关联的MMD密码
  private String uMmdMoney;
  private String uHeadIcon;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Date uRelevancyDate; //关联的MMD的日期
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Date uCrtdate;
  private String uCrtuser;
  private String recsts;

  private Integer shipAddressCount;

  private String source;


  public Long getuId() {
    return uId;
  }

  public void setuId(Long uId) {
    this.uId = uId;
  }

  public String getuName() {
    return uName;
  }

  public void setuName(String uName) {
    this.uName = uName;
  }

  public String getuPhone() {
    return uPhone;
  }

  public void setuPhone(String uPhone) {
    this.uPhone = uPhone;
  }

  public String getuNick() {
    return uNick;
  }

  public void setuNick(String uNick) {
    this.uNick = uNick;
  }

  public String getuSex() {
    return uSex;
  }

  public void setuSex(String uSex) {
    this.uSex = uSex;
  }

  public Long getuAge() {
    return uAge;
  }

  public void setuAge(Long uAge) {
    this.uAge = uAge;
  }

  public Long getuIntegral() {
    return uIntegral;
  }

  public void setuIntegral(Long uIntegral) {
    this.uIntegral = uIntegral;
  }

  public String getuPassword() {
    return uPassword;
  }

  public void setuPassword(String uPassword) {
    this.uPassword = uPassword;
  }

  public String getuIdentity() {
    return uIdentity;
  }

  public void setuIdentity(String uIdentity) {
    this.uIdentity = uIdentity;
  }

  public String getuAddress() {
    return uAddress;
  }

  public void setuAddress(String uAddress) {
    this.uAddress = uAddress;
  }

  public String getuMmdNo() {
    return uMmdNo;
  }

  public void setuMmdNo(String uMmdNo) {
    this.uMmdNo = uMmdNo;
  }

  public String getuMmdPassword() {
    return uMmdPassword;
  }

  public void setuMmdPassword(String uMmdPassword) {
    this.uMmdPassword = uMmdPassword;
  }

  public String getuMmdMoney() {
    return uMmdMoney;
  }

  public void setuMmdMoney(String uMmdMoney) {
    this.uMmdMoney = uMmdMoney;
  }

  public String getuHeadIcon() {
    return uHeadIcon;
  }

  public void setuHeadIcon(String uHeadIcon) {
    this.uHeadIcon = uHeadIcon;
  }

  public Date getuRelevancyDate() {
    return uRelevancyDate;
  }

  public void setuRelevancyDate(Date uRelevancyDate) {
    this.uRelevancyDate = uRelevancyDate;
  }

  public Date getuCrtdate() {
    return uCrtdate;
  }

  public void setuCrtdate(Date uCrtdate) {
    this.uCrtdate = uCrtdate;
  }

  public String getuCrtuser() {
    return uCrtuser;
  }

  public void setuCrtuser(String uCrtuser) {
    this.uCrtuser = uCrtuser;
  }

  public String getRecsts() {
    return recsts;
  }

  public void setRecsts(String recsts) {
    this.recsts = recsts;
  }

  public Integer getShipAddressCount() {
    return shipAddressCount;
  }

  public void setShipAddressCount(Integer shipAddressCount) {
    this.shipAddressCount = shipAddressCount;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }
}
