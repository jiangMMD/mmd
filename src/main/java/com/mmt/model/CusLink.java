package com.mmt.model;

/**
 * 订单中联系人信息
 */
public class CusLink {

    private Long lid;
    private String lname;
    private String lsex;
    private String lrelation;
    private String lphone;
    private String lmemo;
    private String crtuser;
    private String crtdate;
    private String upduser;
    private String upddate;
    private String recsts;

    public CusLink() {
    }

    public CusLink(Long lid, String lname, String lsex, String lrelation, String lphone, String lmemo) {
        this.lid = lid;
        this.lname = lname;
        this.lsex = lsex;
        this.lrelation = lrelation;
        this.lphone = lphone;
        this.lmemo = lmemo;
    }

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

    public String getLphone() {
        return lphone;
    }

    public void setLphone(String lphone) {
        this.lphone = lphone;
    }

    public String getLmemo() {
        return lmemo;
    }

    public void setLmemo(String lmemo) {
        this.lmemo = lmemo;
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

    public String getUpduser() {
        return upduser;
    }

    public void setUpduser(String upduser) {
        this.upduser = upduser;
    }

    public String getUpddate() {
        return upddate;
    }

    public void setUpddate(String upddate) {
        this.upddate = upddate;
    }

    public String getRecsts() {
        return recsts;
    }

    public void setRecsts(String recsts) {
        this.recsts = recsts;
    }


    @Override
    public String toString() {
        return "CusLink{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", lsex='" + lsex + '\'' +
                ", lrelation='" + lrelation + '\'' +
                ", lphone='" + lphone + '\'' +
                ", lmemo='" + lmemo + '\'' +
                ", crtuser='" + crtuser + '\'' +
                ", crtdate='" + crtdate + '\'' +
                ", upduser='" + upduser + '\'' +
                ", upddate='" + upddate + '\'' +
                ", recsts='" + recsts + '\'' +
                '}';
    }
}
