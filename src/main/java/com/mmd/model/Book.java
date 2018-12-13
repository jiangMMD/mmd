package com.mmd.model;


import java.io.Serializable;

public class Book implements Serializable {

  private Long bid;
  private Long uid;
  private String paymenttype;
  private String paymentway;
  private double rmbprice;
  private double mmdprice;
  private String bookno;
  private Long state;
  private Long paystate;
  private double paytotal;
  private double totalrmbprice;
  private double totalmmdprice;
  private String prodnum;



  public Long getBid() {
    return bid;
  }

  public void setBid(Long bid) {
    this.bid = bid;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public String getPaymenttype() {
    return paymenttype;
  }

  public void setPaymenttype(String paymenttype) {
    this.paymenttype = paymenttype;
  }

  public String getPaymentway() {
    return paymentway;
  }

  public void setPaymentway(String paymentway) {
    this.paymentway = paymentway;
  }

  public double getRmbprice() {
    return rmbprice;
  }

  public void setRmbprice(double rmbprice) {
    this.rmbprice = rmbprice;
  }

  public double getMmdprice() {
    return mmdprice;
  }

  public void setMmdprice(double mmdprice) {
    this.mmdprice = mmdprice;
  }

  public String getBookno() {
    return bookno;
  }

  public void setBookno(String bookno) {
    this.bookno = bookno;
  }

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
    this.state = state;
  }

  public Long getPaystate() {
    return paystate;
  }

  public void setPaystate(Long paystate) {
    this.paystate = paystate;
  }

  public double getPaytotal() {
    return paytotal;
  }

  public void setPaytotal(double paytotal) {
    this.paytotal = paytotal;
  }

  public double getTotalrmbprice() {
    return totalrmbprice;
  }

  public void setTotalrmbprice(double totalrmbprice) {
    this.totalrmbprice = totalrmbprice;
  }

  public double getTotalmmdprice() {
    return totalmmdprice;
  }

  public void setTotalmmdprice(double totalmmdprice) {
    this.totalmmdprice = totalmmdprice;
  }

  public String getProdnum() {
    return prodnum;
  }

  public void setProdnum(String prodnum) {
    this.prodnum = prodnum;
  }
}
