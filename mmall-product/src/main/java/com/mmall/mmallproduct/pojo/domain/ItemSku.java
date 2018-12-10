package com.mmall.mmallproduct.pojo.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品规格
 *
 * @author: gg
 * @date: 2018/12/7 12:16
 */
@Data
public class ItemSku implements Serializable {

    /**
     * 规格id
     */
    private Integer id;

    /**
     * 商品模版id
     */
    private Integer itemId;

    /**
     * 规格图片
     */
    private String skuImg;

    /**
     * 规格属性
     */
    private String skuProperties;

    /**
     * 1-删除 0-正常
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 单规格净重
     */
    private Double roughWeight;

    /**
     * 规格组合名称
     */
    private String skuPropertyNames;

}
