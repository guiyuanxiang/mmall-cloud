package com.mmall.mmallproduct.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: gg
 * @date: 2018/12/7 11:48
 */
@Data
public class ItemBasicProperty implements Serializable {

    /**
     * 商品模版id
     */
    private Integer itemId;

    /**
     * 商品属性Id
     */
    private Integer skuPropertyId;

    /**
     * 商品SKUId
     */
    private Integer itemSkuId;


    /**
     * 是否有sku 0-无 1-有
     */
    private Boolean skuDisplay;

    /**
     * 是否展示 0-否 1-是
     */
    private Boolean isDisplay;

    /**
     * 1-删除 0-正常
     */
    private Boolean isDeleted;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
