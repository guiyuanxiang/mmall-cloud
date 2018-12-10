package com.mmall.mmallproduct.controller;

import com.mmall.mmallproduct.pojo.param.ItemParam;
import com.mmall.mmallproduct.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: gg
 * @date: 2018/12/10 20:04
 */
@RestController
@RequestMapping("/item/")
public class ItemController {

    @Resource
    private ItemService itemService;

    @GetMapping("list")
    public Object list(ItemParam itemParam) {
        ItemParam.initPage(itemParam);
        return itemService.list(itemParam);
    }
}
