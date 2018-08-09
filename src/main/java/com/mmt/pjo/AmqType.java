package com.mmt.pjo;

public enum AmqType {

    type1("1", "客户申请产品"), type2("2", "申请产品"), type3("3", "客户还款");

    String code;
    String name;

    AmqType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
