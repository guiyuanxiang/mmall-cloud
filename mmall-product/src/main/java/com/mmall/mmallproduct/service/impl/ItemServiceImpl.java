package com.mmall.mmallproduct.service.impl;

import com.mmall.mmallproduct.mapper.ItemMapper;
import com.mmall.mmallproduct.pojo.param.ItemParam;
import com.mmall.mmallproduct.pojo.vo.ItemVo;
import com.mmall.mmallproduct.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品服务实现类
 *
 * @author: gg
 * @date: 2018/12/10 17:52
 */
@Service("itemServiceImpl")
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;


    /**
     * 商品列表
     *
     * @param itemParam ItemParam
     * @return List<ItemVo>
     */
    @Override
    public List<ItemVo> list(ItemParam itemParam) {
        return null;
    }
}
