package com.mmall.mmallproduct.pojo.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * erp商品表
 * @author gg
 */
@Data
public class ErpItem implements Serializable {

    /**
     * erp商品id
     */
    private Integer id;

    /**
     * 商品模版id
     */
    private Integer itemId;

    /**
     * 生产日期
     */
    private Date producedDate;

    /**
     * 采购的单价
     */
    private BigDecimal purchaseUnitPrice;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

}