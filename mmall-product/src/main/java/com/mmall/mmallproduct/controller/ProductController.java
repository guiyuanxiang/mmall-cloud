package com.mmall.mmallproduct.controller;

import com.mmall.common.util.ServerResponse;
import com.mmall.mmallproduct.pojo.param.ProductParam;
import com.mmall.mmallproduct.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: gg
 * @date: 2018/12/10 20:04
 */
@RestController
@RequestMapping("/product/")
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * 分页列表
     *
     * @param productParam ProductParam
     * @return ServerResponse ItemVo list结构
     */
    @GetMapping("list")
    public ServerResponse list(ProductParam productParam) {
        ProductParam.initPage(productParam);
        return ServerResponse.createBySuccess(productService.list(productParam));
    }

    /**
     * 商品详情
     *
     * @param id 商品id
     * @return ServerResponse ItemVo 单个对象
     */
    @GetMapping("detail")
    public ServerResponse detail(Integer id) {
        return ServerResponse.createBySuccess(productService.detail(id));
    }
}
