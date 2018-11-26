package com.mmd.model;

import java.io.Serializable;

public class Post implements Serializable{

    private long pid; //职位id
    private String pname; //职位名称
    private String pdesc; //职位描述
    private String crtdate;
    private String crtuser;
    private String upddate;
    private String upduser;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getCrtdate() {
        return crtdate;
    }

    public void setCrtdate(String crtdate) {
        this.crtdate = crtdate;
    }

    public String getCrtuser() {
        return crtuser;
    }

    public void setCrtuser(String crtuser) {
        this.crtuser = crtuser;
    }

    public String getUpddate() {
        return upddate;
    }

    public void setUpddate(String upddate) {
        this.upddate = upddate;
    }

    public String getUpduser() {
        return upduser;
    }

    public void setUpduser(String upduser) {
        this.upduser = upduser;
    }
}
