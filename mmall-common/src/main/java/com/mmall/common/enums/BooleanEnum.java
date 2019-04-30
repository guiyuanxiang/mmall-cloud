/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.mmall.common.enums;

/**
 * @author gg
 * @version BooleanEnum.java, v 0.1 2019-03-13 11:26 gg
 */
public enum BooleanEnum {

    TRUE("是", 1),
    FALSE("否", 0),
    ;

    private String name;
    private Integer value;

    BooleanEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for property <tt>value</tt>.
     *
     * @return property value of value
     */
    public Integer getValue() {
        return value;
    }

    public static BooleanEnum getByValue(Integer value) {
        BooleanEnum[] valueList = BooleanEnum.values();
        for (BooleanEnum v : valueList) {
            if (v.getValue().equals(value)) {
                return v;
            }
        }
        return null;
    }
}