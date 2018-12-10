package com.mmall.mmallproduct.pojo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: gg
 * @date: 2018/12/10 17:12
 */
@Data
public class ItemMainImg implements Serializable {

    private Integer itemId;

    /**
     * 主图
     */
    private String mainImg;
}
