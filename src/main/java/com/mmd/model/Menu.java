package com.mmd.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单，
 */
@Data
public class Menu implements Serializable{

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

}
