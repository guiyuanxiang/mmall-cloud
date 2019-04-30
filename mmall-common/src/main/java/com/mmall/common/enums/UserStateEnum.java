package com.mmall.common.enums;

import lombok.Getter;

/**
 * @author guigu
 */
@Getter
public enum UserStateEnum {

    Normal_USE(1, "正常"),
    DisAble_USE(2, "停用");

    private Integer value;
    private String name;

    UserStateEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

}
