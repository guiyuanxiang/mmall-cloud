package com.mmall.mmallproduct.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
     * 主图 todo 大字段单独列表
     */
    private String mainImg;

    /**
     * 商品属性
     */
    private String property;

    /**
     * 商品描述 todo 大字段单独列表
     */
    private String description;

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

    /*非数据库字段*/
    /**
     * 贸易类型 1-国内贸易，2-保税区直供，3-海外直邮
     */
    private Integer sendWay;

    /**
     * 建议价
     */
    private BigDecimal suggestedPrice;


    /**
     * 库存计算方式 0-下单减库存 1-支付减库存
     */
    private Integer stockWay;

    /**
     * 提成设置id
     */
    private Integer promoteGroupId;

    /**
     * 提成设置名称
     */

    private String promoteGroupName;


    /**
     * 浏览量 非本表数据
     */
    private Long pageView;
    private String categoryNameThree;
    private String categoryNameTwo;
    private String categoryNameOne;
    private Long categoryIdThree;
    private Long categoryIdTwo;
    private Long categoryIdOne;
    private String brandName;
    private List<ItemSku> itemSkuList;
    private String unit;
}
