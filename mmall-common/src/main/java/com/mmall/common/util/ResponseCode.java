package com.mmall.common.util;

/**
 * @author: gg
 * @date: 2018/12/11 16:43
 */
public enum ResponseCode {

    SUCCESS(200, "SUCCESS"),
    ERROR(500, "ERROR"),
    NEED_LOGIN(401, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(400, "ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;


    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

