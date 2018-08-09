package com.mmt.model;

public class Payment {

    private Long pid;
    private Long bid;
    private Integer curphase;
    private Integer state;
    private String money;
    private String issms;
    private String totalmoney; //实际应还总额（每期基础费用+本期的逾期费） 如果是由租转售，那么直接就设置该期还清所有
    private String realymoney;
    private String date;
    private String realydate;
    private String expectfee;
    private String finishuser;
    private String finishdate;
    private String crtuser;
    private String crtdate;
    private String recsts;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Integer getCurphase() {
        return curphase;
    }

    public void setCurphase(Integer curphase) {
        this.curphase = curphase;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getRealymoney() {
        return realymoney;
    }

    public void setRealymoney(String realymoney) {
        this.realymoney = realymoney;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRealydate() {
        return realydate;
    }

    public void setRealydate(String realydate) {
        this.realydate = realydate;
    }

    public String getCrtuser() {
        return crtuser;
    }

    public void setCrtuser(String crtuser) {
        this.crtuser = crtuser;
    }

    public String getCrtdate() {
        return crtdate;
    }

    public void setCrtdate(String crtdate) {
        this.crtdate = crtdate;
    }

    public String getRecsts() {
        return recsts;
    }

    public void setRecsts(String recsts) {
        this.recsts = recsts;
    }

    public String getExpectfee() {
        return expectfee;
    }

    public void setExpectfee(String expectfee) {
        this.expectfee = expectfee;
    }

    public String getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(String totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getFinishuser() {
        return finishuser;
    }

    public void setFinishuser(String finishuser) {
        this.finishuser = finishuser;
    }

    public String getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(String finishdate) {
        this.finishdate = finishdate;
    }

    public String getIssms() {
        return issms;
    }

    public void setIssms(String issms) {
        this.issms = issms;
    }
}
