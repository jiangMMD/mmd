package com.mmt.model;

import java.util.List;

/**
 * 权限表，处理员工的权限问题
 */
public class Role {

    private long rid;
    private String rname; //权限名称
    private String rdesc; //权限描述
    private String menu_ids; //菜单id
    private List<Menu> menuList; //菜单列表
    private String crtdate;
    private String crtuser;
    private String upddate;
    private String upduser;

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
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

    public String getMenu_ids() {
        return menu_ids;
    }

    public void setMenu_ids(String menu_ids) {
        this.menu_ids = menu_ids;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", rdesc='" + rdesc + '\'' +
                ", menu_ids='" + menu_ids + '\'' +
                ", menuList=" + menuList +
                ", crtdate='" + crtdate + '\'' +
                ", crtuser='" + crtuser + '\'' +
                ", upddate='" + upddate + '\'' +
                ", upduser='" + upduser + '\'' +
                '}';
    }
}
