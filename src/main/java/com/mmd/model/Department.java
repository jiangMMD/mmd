package com.mmd.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 部门信息
 */
@Data
public class Department implements Serializable{

    private Long depId; //部门id;
    private String depName; //部门名称；
    private String depDesc; //部门描述
    private List<Post> postList; //职位信息
    private String crtdate;
    private String crtuser;
    private String upddate;
    private String upduser;


}
