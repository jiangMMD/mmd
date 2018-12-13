package com.mmd.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ProdEvaluate implements Serializable {

  private Long id;
  private String pname;
  private String uname;
  private String bookno;
  private String skuvalname;
  private String word;
  private Long bestcount;
  private Long mediumccount;
  private Long badcount;
  private Long bid;
  private Long pid;
  private Long skuId;
  private Long uid;
  private Long swId;
  private Long starlevel;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date evdate;
  private String productmap;
  private String commentcount;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPname() {
    return pname;
  }

  public void setPname(String pname) {
    this.pname = pname;
  }

  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }

  public String getBookno() {
    return bookno;
  }

  public void setBookno(String bookno) {
    this.bookno = bookno;
  }

  public String getSkuvalname() {
    return skuvalname;
  }

  public void setSkuvalname(String skuvalname) {
    this.skuvalname = skuvalname;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public Long getBestcount() {
    return bestcount;
  }

  public void setBestcount(Long bestcount) {
    this.bestcount = bestcount;
  }

  public Long getMediumccount() {
    return mediumccount;
  }

  public void setMediumccount(Long mediumccount) {
    this.mediumccount = mediumccount;
  }

  public Long getBadcount() {
    return badcount;
  }

  public void setBadcount(Long badcount) {
    this.badcount = badcount;
  }

  public Long getBid() {
    return bid;
  }

  public void setBid(Long bid) {
    this.bid = bid;
  }

  public Long getPid() {
    return pid;
  }

  public void setPid(Long pid) {
    this.pid = pid;
  }

  public Long getSkuId() {
    return skuId;
  }

  public void setSkuId(Long skuId) {
    this.skuId = skuId;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public Long getSwId() {
    return swId;
  }

  public void setSwId(Long swId) {
    this.swId = swId;
  }

  public Long getStarlevel() {
    return starlevel;
  }

  public void setStarlevel(Long starlevel) {
    this.starlevel = starlevel;
  }

  public Date getEvdate() {
    return evdate;
  }

  public void setEvdate(Date evdate) {
    this.evdate = evdate;
  }

  public String getProductmap() {
    return productmap;
  }

  public void setProductmap(String productmap) {
    this.productmap = productmap;
  }

  public String getCommentcount() {
    return commentcount;
  }

  public void setCommentcount(String commentcount) {
    this.commentcount = commentcount;
  }
}