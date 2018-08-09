package com.mmt.model;

import java.util.List;

/**
 * 菜单，
 */
public class Menu {

    private long mid;
    private String mname; //菜单名称
    private String micon; //菜单图标名称,主菜单及其三级菜单具有
    private String murl; //菜单地址
    private String mdesc; //菜单描述
    private String order; //排序
    private List<Menu> childMenu; //子菜单
    private String crtdate;
    private String crtuser;
    private String upddate;
    private String upduser;


    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMicon() {
        return micon;
    }

    public void setMicon(String micon) {
        this.micon = micon;
    }

    public String getMdesc() {
        return mdesc;
    }

    public void setMdesc(String mdesc) {
        this.mdesc = mdesc;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }

    public List<Menu> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<Menu> childMenu) {
        this.childMenu = childMenu;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", micon='" + micon + '\'' +
                ", murl='" + murl + '\'' +
                ", mdesc='" + mdesc + '\'' +
                ", childMenu=" + childMenu +
                ", crtdate='" + crtdate + '\'' +
                ", crtuser='" + crtuser + '\'' +
                ", upddate='" + upddate + '\'' +
                ", upduser='" + upduser + '\'' +
                '}';
    }
}
