package com.mmd.model;


public class Homecarousel {

  private long id;
  private long pid;
  private String imgurl;
  private long orderby;
  private String crtuser;
  private java.sql.Timestamp crtdate;
  private String recsts;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public String getImgurl() {
    return imgurl;
  }

  public void setImgurl(String imgurl) {
    this.imgurl = imgurl;
  }


  public long getOrderby() {
    return orderby;
  }

  public void setOrderby(long orderby) {
    this.orderby = orderby;
  }


  public String getCrtuser() {
    return crtuser;
  }

  public void setCrtuser(String crtuser) {
    this.crtuser = crtuser;
  }


  public java.sql.Timestamp getCrtdate() {
    return crtdate;
  }

  public void setCrtdate(java.sql.Timestamp crtdate) {
    this.crtdate = crtdate;
  }


  public String getRecsts() {
    return recsts;
  }

  public void setRecsts(String recsts) {
    this.recsts = recsts;
  }

}
