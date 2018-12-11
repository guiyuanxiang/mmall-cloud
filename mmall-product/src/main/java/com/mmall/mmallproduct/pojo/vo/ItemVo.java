package com.mmall.mmallproduct.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: gg
 * @date: 2018/12/10 17:35
 */
@Data
public class ItemVo implements Serializable{

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
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

}
