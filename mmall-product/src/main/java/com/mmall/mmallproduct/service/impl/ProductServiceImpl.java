package com.mmall.mmallproduct.service.impl;

import com.mmall.mmallproduct.mapper.ProductMapper;
import com.mmall.mmallproduct.pojo.model.Product;
import com.mmall.mmallproduct.pojo.param.ProductParam;
import com.mmall.mmallproduct.pojo.vo.ProductVo;
import com.mmall.mmallproduct.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品服务实现类
 *
 * @author: gg
 * @date: 2018/12/10 17:52
 */
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;


    /**
     * 商品列表
     *
     * @param productParam ProductParam
     * @return List<ProductVo>
     */
    @Override
    public List<ProductVo> list(ProductParam productParam) {
        List<Product> items = productMapper.list(productParam);
        return items.stream().map(this::toVo).distinct().collect(Collectors.toList());
    }

    /**
     * 商品详情
     *
     * @param id 商品id
     * @return ItemVo
     */
    @Override
    public ProductVo detail(Integer id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return toVo(product);
    }

    private ProductVo toVo(Product product) {
        ProductVo productVo = new ProductVo();
        BeanUtils.copyProperties(product, productVo);
        return productVo;
    }
}
