package com.mmt.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 客户联系人信息
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cus_Link {

    private Long lid;
    private String lname;
    private String lphone;
    private String lsex;
    private String lrelation;
    private String lmemo;
    private String crtdate;


    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLphone() {
        return lphone;
    }

    public void setLphone(String lphone) {
        this.lphone = lphone;
    }

    public String getLsex() {
        return lsex;
    }

    public void setLsex(String lsex) {
        this.lsex = lsex;
    }

    public String getLrelation() {
        return lrelation;
    }

    public void setLrelation(String lrelation) {
        this.lrelation = lrelation;
    }

    public String getLmemo() {
        return lmemo;
    }

    public void setLmemo(String lmemo) {
        this.lmemo = lmemo;
    }

    public String getCrtdate() {
        return crtdate;
    }

    public void setCrtdate(String crtdate) {
        this.crtdate = crtdate;
    }
}
