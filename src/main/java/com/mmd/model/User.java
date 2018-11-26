package com.mmd.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class User {

  private Long uId;
  private String uName;
  private String uPhone;
  private String uNick;
  private String uSex;
  private Long uAge;
  private Long uIntegral; //用户剩余积分
  private String uPassword;
  private String uIdentity;
  private String uAddress; //用户家庭住址
  private String uMmdNo; //关联的MMD账户
  private String uMmdPassword; //关联的MMD地址
  private String uMmdMoney;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date uRelevancyDate; //关联的MMD的日期
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date uCrtdate;
  private String uCrtuser;

}
