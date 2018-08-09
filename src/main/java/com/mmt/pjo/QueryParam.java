package com.mmt.pjo;

import java.util.List;

public class QueryParam {

    private String groupOp;
    private List<Relation> rules;

    public String getGroupOp() {
        return groupOp;
    }

    public void setGroupOp(String groupOp) {
        this.groupOp = groupOp;
    }

    public List<Relation> getRules() {
        return rules;
    }

    public void setRules(List<Relation> rules) {
        this.rules = rules;
    }

    public final static String AND = "AND";
    public final static String OR = "OR";
    public final static String EQ = "eq";//等于
    public final static String NE = "ne";//不等于
    public final static String BW = "bw";//开始于
    public final static String BN = "bn";//不开始于
    public final static String EW = "ew";//结束于
    public final static String EN = "en";//不结束于
    public final static String CN = "cn";//包含
    public final static String NC = "nc";//不包含
    public final static String IN = "in";//属于
    public final static String NI = "ni";//不属于
    public final static String NN = "nn"; //存在
    public final static String NU = "nu"; //不存在



}
