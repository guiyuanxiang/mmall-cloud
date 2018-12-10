package com.mmall.mmallproduct.service;

import com.mmall.mmallproduct.pojo.param.ItemParam;
import com.mmall.mmallproduct.pojo.vo.ItemVo;

import java.util.List;

/**
 * @author: gg
 * @date: 2018/12/10 17:33
 */
public interface ItemService {

    List<ItemVo> list(ItemParam itemParam);
}
