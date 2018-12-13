package com.mmd.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Message {

  private Long id;
  private String title;
  private String content;
  private Long userId;
  private String uname;
  private String uphone;
  private String type;
  private String picUrl;
  private String isread;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
  private Date crtdate;
  private String crtuser;
  private String startDate;
  private String endDate;

}
