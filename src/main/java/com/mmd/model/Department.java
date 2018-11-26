package com.mmd.model;

import java.io.Serializable;
import java.util.List;

/**
 * 部门信息
 */
public class Department implements Serializable{

    private long dep_id; //部门id;
    private String dep_name; //部门名称；
    private String dep_desc; //部门描述
    private List<Post> postList; //职位信息
    private String crtdate;
    private String crtuser;
    private String upddate;
    private String upduser;

    public long getDep_id() {
        return dep_id;
    }

    public void setDep_id(long dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getDep_desc() {
        return dep_desc;
    }

    public void setDep_desc(String dep_desc) {
        this.dep_desc = dep_desc;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
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
