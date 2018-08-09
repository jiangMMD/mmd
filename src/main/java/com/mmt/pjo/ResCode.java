package com.mmt.pjo;

public enum ResCode {

    OperSuc(1, "操作成功！"), QuerySuc(1, "查询成功！"), OperErr(0, "操作失败！");

    int code;
    String message;
    ResCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
