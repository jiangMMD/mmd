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
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date crtdate;
  private String crtuser;
  private String recsts;


}
