package com.mmd.model;


public class ProdSku {

  private Long skuId;
  private Long pid;
  private String skuVal;
  private Double price;
  private Double mmdprice;
  private Long repertory;
  private Long salenum;
  private Long length;


  public Long getSkuId() {
    return skuId;
  }

  public void setSkuId(Long skuId) {
    this.skuId = skuId;
  }

  public Long getPid() {
    return pid;
  }

  public void setPid(Long pid) {
    this.pid = pid;
  }

  public String getSkuVal() {
    return skuVal;
  }

  public void setSkuVal(String skuVal) {
    this.skuVal = skuVal;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getMmdprice() {
    return mmdprice;
  }

  public void setMmdprice(Double mmdprice) {
    this.mmdprice = mmdprice;
  }

  public Long getRepertory() {
    return repertory;
  }

  public void setRepertory(Long repertory) {
    this.repertory = repertory;
  }

  public Long getSalenum() {
    return salenum;
  }

  public void setSalenum(Long salenum) {
    this.salenum = salenum;
  }

  public Long getLength() {
    return length;
  }

  public void setLength(Long length) {
    this.length = length;
  }
}
