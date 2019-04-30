package com.mmall.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.mmall.admin.pojo.entity.RoleResourceEntity;

/**
 * @author guigu
 */
@Mapper
public interface RoleResourceMapper {


    /**
     * 选择插入
     *
     * @param roleResourceEntity RoleResourceEntity
     * @return int
     */
    int insertSelective(@Param("roleResourceEntity") RoleResourceEntity roleResourceEntity);

    /**
     * 批量插入
     *
     * @param roleResourceEntitys List<RoleResourceEntity>
     * @return int
     */
    int insertList(@Param("roleResourceEntitys") List<RoleResourceEntity> roleResourceEntitys);

    /**
     * 选择更新
     *
     * @param roleResourceEntity RoleResourceEntity
     * @return int
     */
    int updateByPrimaryKeySelective(@Param("roleResourceEntity") RoleResourceEntity roleResourceEntity);

    /**
     * 根据角色id查询权限id
     *
     * @param roleId 角色id
     * @return 权限id
     */
    List<Long> selectByRoleId(long roleId);
}
