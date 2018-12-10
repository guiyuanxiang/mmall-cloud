package com.mmall.mmallproduct.pojo.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品模版
 *
 * @author: gg
 * @date: 2018/12/7 11:43
 */
@Data
public class Item implements Serializable {

    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String title;

    /**
     * 商品编码
     */
    private String itemCode;

    /**
     * 商品条码
     */
    private String barCode;

    /**
     * 商品属性
     */
    private String property;

    /**
     * 商品卖点
     */
    private String sellingPoint;

    /**
     * 购买提醒
     */
    private String buyRemind;

    /**
     * 保质期
     */
    private Date expirationDate;


    /**
     * 商品标签
     */
    private String tags;


    /**
     * 商品类目id
     */
    private Integer categoryId;

    /**
     * 商品品牌id
     */
    private Integer brandId;

    /**
     * 单位id
     */
    private Integer unitId;

    /**
     * 是否有保质期 0-无 1-有
     */
    private Integer expirationDateStatus;

    /**
     * 商品类型 0-实物 1-虚拟类商品比如服务
     */
    private Integer itemType;

    /**
     * 是否是赠品 0-不是 1-是
     */
    private Boolean isPresent;

    /**
     * 是否放入回收站 0-不是 1-是
     */
    private Boolean isRecycle;

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
