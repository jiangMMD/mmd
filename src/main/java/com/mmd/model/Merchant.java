package com.mmd.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class Merchant {

  private Long merId;
  private String merType;
  private String merName;
  private String merDesc;
  private String merAddress;
  private String merHomeimg; //请求地址
  private String merHomeicon; //请求地址
  private String merLinkman;
  private String merLinkphone;
  private String merWeixin;
  private String merQq;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Date crtdate;
  private String crtuser;
  private Date update;
  private String upduser;
  private String recsts;
  private Integer hotval;
  private Integer hits;
  private Integer isHot;
  private String merShortname;
  private String merEname;


}
