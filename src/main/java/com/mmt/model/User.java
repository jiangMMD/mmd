package com.mmt.model;

import java.io.Serializable;
import java.util.List;

/**
 * 公司内部员工用户实体类
 */
public class User implements Serializable{

    private Long uid;
    private String user_no;
    private String username;
    private String password;
    private String dep_no; // 部门id;
    private String dep_name; //部门名称
    private String cellphone; //手机
    private String telephone; //座机
    private String weixin; //微信
    private String qq; //QQ
    private String post_id; //职位id;
    private String post; //职位名称
    private Post post_names; //职位, 可以有多个职位
    private Integer age;
    private String sex;
    private String birthday; //生日
    private String dep_id;
    private String agency_ids; //代理商id
    private String agencys; //代理商名称
    private Department department; //部门相关信息
    private List<Post> postList;
    private Boolean isadmin; //是否是管理员，管理员可以查看所有菜单
    private String role_id;
    private List<Role> roles; //用户权限---用于分发菜单
    private String headicon; //用户头像
    private String upduser;
    private String crtuser;


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUser_no() {
        return user_no;
    }

    public void setUser_no(String user_no) {
        this.user_no = user_no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDep_no() {
        return dep_no;
    }

    public void setDep_no(String dep_no) {
        this.dep_no = dep_no;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public Post getPost_names() {
        return post_names;
    }

    public void setPost_names(Post post_names) {
        this.post_names = post_names;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDep_id() {
        return dep_id;
    }

    public void setDep_id(String dep_id) {
        this.dep_id = dep_id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getHeadicon() {
        return headicon;
    }

    public void setHeadicon(String headicon) {
        this.headicon = headicon;
    }

    public String getUpduser() {
        return upduser;
    }

    public void setUpduser(String upduser) {
        this.upduser = upduser;
    }

    public String getCrtuser() {
        return crtuser;
    }

    public void setCrtuser(String crtuser) {
        this.crtuser = crtuser;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAgency_ids() {
        return agency_ids;
    }

    public void setAgency_ids(String agency_ids) {
        this.agency_ids = agency_ids;
    }

    public String getAgencys() {
        return agencys;
    }

    public void setAgencys(String agencys) {
        this.agencys = agencys;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", user_no='" + user_no + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dep_no='" + dep_no + '\'' +
                ", dep_name='" + dep_name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", weixin='" + weixin + '\'' +
                ", qq='" + qq + '\'' +
                ", post_names=" + post_names +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", dep_id='" + dep_id + '\'' +
                ", department=" + department +
                ", postList=" + postList +
                ", isadmin=" + isadmin +
                ", role_id='" + role_id + '\'' +
                ", roles=" + roles +
                ", headicon='" + headicon + '\'' +
                ", upduser='" + upduser + '\'' +
                ", crtuser='" + crtuser + '\'' +
                '}';
    }
}
