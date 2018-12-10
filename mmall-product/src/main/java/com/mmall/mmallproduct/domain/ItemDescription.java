package com.mmall.mmallproduct.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: gg
 * @date: 2018/12/10 17:15
 */
@Data
public class ItemDescription implements Serializable{

    private Integer itemId;

    /**
     * 描述
     */
    private String description;
}
