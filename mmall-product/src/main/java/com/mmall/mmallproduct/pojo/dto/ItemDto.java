package com.mmall.mmallproduct.pojo.dto;

import com.mmall.mmallproduct.pojo.domain.Item;
import com.mmall.mmallproduct.pojo.domain.ItemSku;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author: gg
 * @date: 2018/12/10 17:18
 */
@Data
public class ItemDto extends Item implements Serializable{

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
