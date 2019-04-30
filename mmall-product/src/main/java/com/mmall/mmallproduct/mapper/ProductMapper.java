package com.mmall.mmallproduct.mapper;

import com.mmall.mmallproduct.pojo.model.Product;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

/**
 * Created by Mybatis Generator 2019/04/25
 */
@Mapper
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

}