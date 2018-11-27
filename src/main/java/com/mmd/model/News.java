package com.mmd.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class News implements Serializable{

  private Long id;
  private String title;
  private String content;
  private String type;
  private String isread;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date crtdate;
  private String crtuser;

}
