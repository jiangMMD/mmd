package com.mmd.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Productsinfo {

  private Long pid;
  private Long merId;
  private String merName;
  private Long state;
  private String pname;
  private String title;
  private String desc;
  private String homeimg;
  private String paramimg;
  private String categoryid;
  private Double shopprice;
  private Double shopmmdprice;
  private Double costprice;
  private Long isbest;
  private Long ishot;
  private Long isnew;
  private Long isfree;
  private Double expressfee;
  private Double weight;
  private Double volume;
  private Long inventory;
  private Long sell;
  private Long commentcount;
  private Long bestcount;
  private Long mediumccount;
  private Long badcount;
  private Double average;
  private Long isflashview;
  private String serviceIds;
  private String crtuser;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
  private Date crtdate;
  private String recsts;
  private String proClassify;
  private String prodno;
  private Integer isproportion;


  //轮播图集合
  private List<Map<String, Object>> carousalList;
  //产品详情图集合
  private List<Map<String, Object>> detailList;
  //服务集合
  private List<Map<String, Object>> serviceList;


  public Long getPid() {
    return pid;
  }

  public void setPid(Long pid) {
    this.pid = pid;
  }

  public Long getMerId() {
    return merId;
  }

  public void setMerId(Long merId) {
    this.merId = merId;
  }

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
    this.state = state;
  }

  public String getPname() {
    return pname;
  }

  public void setPname(String pname) {
    this.pname = pname;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getHomeimg() {
    return homeimg;
  }

  public void setHomeimg(String homeimg) {
    this.homeimg = homeimg;
  }

  public String getParamimg() {
    return paramimg;
  }

  public void setParamimg(String paramimg) {
    this.paramimg = paramimg;
  }

  public String getMerName() {
    return merName;
  }

  public void setMerName(String merName) {
    this.merName = merName;
  }

  public List<Map<String, Object>> getDetailList() {
    return detailList;
  }

  public void setDetailList(List<Map<String, Object>> detailList) {
    this.detailList = detailList;
  }

  public String getProClassify() {
    return proClassify;
  }

  public void setProClassify(String proClassify) {
    this.proClassify = proClassify;
  }

  public String getCategoryid() {
    return categoryid;
  }

  public void setCategoryid(String categoryid) {
    this.categoryid = categoryid;
  }

  public Double getShopprice() {
    return shopprice;
  }

  public void setShopprice(Double shopprice) {
    this.shopprice = shopprice;
  }

  public Double getShopmmdprice() {
    return shopmmdprice;
  }

  public void setShopmmdprice(Double shopmmdprice) {
    this.shopmmdprice = shopmmdprice;
  }

  public Double getCostprice() {
    return costprice;
  }

  public void setCostprice(Double costprice) {
    this.costprice = costprice;
  }

  public Long getIsbest() {
    return isbest;
  }

  public void setIsbest(Long isbest) {
    this.isbest = isbest;
  }

  public Long getIshot() {
    return ishot;
  }

  public void setIshot(Long ishot) {
    this.ishot = ishot;
  }

  public Long getIsnew() {
    return isnew;
  }

  public void setIsnew(Long isnew) {
    this.isnew = isnew;
  }

  public Long getIsfree() {
    return isfree;
  }

  public void setIsfree(Long isfree) {
    this.isfree = isfree;
  }

  public Double getExpressfee() {
    return expressfee;
  }

  public void setExpressfee(Double expressfee) {
    this.expressfee = expressfee;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Double getVolume() {
    return volume;
  }

  public void setVolume(Double volume) {
    this.volume = volume;
  }

  public Long getInventory() {
    return inventory;
  }

  public void setInventory(Long inventory) {
    this.inventory = inventory;
  }

  public Long getSell() {
    return sell;
  }

  public void setSell(Long sell) {
    this.sell = sell;
  }

  public Long getCommentcount() {
    return commentcount;
  }

  public void setCommentcount(Long commentcount) {
    this.commentcount = commentcount;
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

  public Double getAverage() {
    return average;
  }

  public void setAverage(Double average) {
    this.average = average;
  }

  public Long getIsflashview() {
    return isflashview;
  }

  public void setIsflashview(Long isflashview) {
    this.isflashview = isflashview;
  }

  public String getServiceIds() {
    return serviceIds;
  }

  public void setServiceIds(String serviceIds) {
    this.serviceIds = serviceIds;
  }

  public String getCrtuser() {
    return crtuser;
  }

  public void setCrtuser(String crtuser) {
    this.crtuser = crtuser;
  }

  public Date getCrtdate() {
    return crtdate;
  }

  public void setCrtdate(Date crtdate) {
    this.crtdate = crtdate;
  }

  public String getRecsts() {
    return recsts;
  }

  public void setRecsts(String recsts) {
    this.recsts = recsts;
  }

  public List<Map<String, Object>> getCarousalList() {
    return carousalList;
  }

  public void setCarousalList(List<Map<String, Object>> carousalList) {
    this.carousalList = carousalList;
  }

  public List<Map<String, Object>> getServiceList() {
    return serviceList;
  }

  public void setServiceList(List<Map<String, Object>> serviceList) {
    this.serviceList = serviceList;
  }

  public String getProdno() {
    return prodno;
  }

  public void setProdno(String prodno) {
    this.prodno = prodno;
  }

  public Integer getIsproportion() {
    return isproportion;
  }

  public void setIsproportion(Integer isproportion) {
    this.isproportion = isproportion;
  }
}
