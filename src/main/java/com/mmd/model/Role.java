package com.mmd.model;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 权限表，处理员工的权限问题
 */
@Data
public class Role implements Serializable{

    private long rid;
    private String rname; //权限名称
    private String rdesc; //权限描述
    private String menu_ids; //菜单id
    private Set<String> munuSet;
    private List<Menu> menuList; //菜单列表
    private String crtdate;
    private String crtuser;
    private String upddate;
    private String upduser;
}
