package com.mmd.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class IntegralLog {

  private Long id;
  private Long uid;
  private Long igvalue;
  private Long type;
  private Long source;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Date opertime;
  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public Long getIgvalue() {
    return igvalue;
  }

  public void setIgvalue(Long igvalue) {
    this.igvalue = igvalue;
  }

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

  public Long getSource() {
    return source;
  }

  public void setSource(Long source) {
    this.source = source;
  }

  public Date getOpertime() {
    return opertime;
  }

  public void setOpertime(Date opertime) {
    this.opertime = opertime;
  }

  @Override
  public String toString() {
    return "IntegralLog{" +
            "id=" + id +
            ", uid=" + uid +
            ", igvalue=" + igvalue +
            ", type=" + type +
            ", source=" + source +
            ", opertime=" + opertime +
            ", username='" + username + '\'' +
            '}';
  }
}
