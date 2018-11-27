package com.mmd.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Employee implements Serializable{

  private Long id;
  private String name;
  private String password;
  private String rname;
  private String depName;
  private String loginNo;
  private String cellphone;
  private Integer age;
  private String sex;
  private String birthday;
  private String weixin;
  private String qq;
  private String roleId;
  private String depId;
  private String postId;
  private String headicon;
  private String isadmin;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date crtdate;
  private String crtuser;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date update;
  private String upduser;
  private String recsts;

  private List<Role> roles; //用户权限---用于分发菜单
  private Department department; //部门相关信息
  private List<Post> postList;

}
