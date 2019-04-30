package com.mmall.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.mmall.admin.pojo.entity.ResourceEntity;

/**
 * @author guigu
 */
@Mapper
public interface ResourceMapper {

    /**
     * 新增
     *
     * @param resourceEntity ResourceEntity
     * @return int
     */
    int insertSelective(@Param("resourceEntity") ResourceEntity resourceEntity);

    /**
     * 批量新增
     *
     * @param resourceEntitys List<ResourceEntity>
     * @return int
     */
    int insertList(@Param("resourceEntitys") List<ResourceEntity> resourceEntitys);

    /**
     * 选择更新
     *
     * @param resourceEntity ResourceEntity
     * @return int
     */
    int updateByPrimaryKeySelective(@Param("resourceEntity") ResourceEntity resourceEntity);

    /**
     * 批量获取权限
     *
     * @param list List<Long>
     * @return List<ResourceEntity>
     */
    List<ResourceEntity> selectButton(List<Long> list);
}
