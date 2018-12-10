package com.mmall.mmallproduct.mapper;

import com.mmall.mmallproduct.pojo.domain.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {

    /**
     * 选择性插入
     *
     * @param item Item
     * @return int
     */
    int insertSelective(@Param("item") Item item);

    /**
     * 批量插入
     *
     * @param items List<Item>
     * @return int
     */
    int insertList(@Param("items") List<Item> items);

    /**
     * 更新
     *
     * @param item Item
     * @return int
     */
    int update(@Param("item") Item item);
}
