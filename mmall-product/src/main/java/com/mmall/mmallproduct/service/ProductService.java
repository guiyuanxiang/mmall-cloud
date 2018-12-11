package com.mmall.mmallproduct.service;

import com.mmall.mmallproduct.pojo.param.ProductParam;
import com.mmall.mmallproduct.pojo.vo.ProductVo;

import java.util.List;

/**
 * @author: gg
 * @date: 2018/12/10 17:33
 */
public interface ProductService {

    /**
     * 商品分页
     *
     * @param productParam 商品参数
     * @return List<ItemVo>
     */
    List<ProductVo> list(ProductParam productParam);

    /**
     * 商品详情
     *
     * @param id 商品id
     * @return ItemVo
     */
    ProductVo detail(Integer id);
}
