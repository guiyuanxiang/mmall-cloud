package com.mmall.admin.pojo.entity;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.mmall.admin.pojo.entity.RolesEntity;

@Mapper
public interface RolesMapper {

    /**
     * 选择插入
     *
     * @param rolesEntity RolesEntity
     * @return int
     */
    int insertSelective(@Param("rolesEntity") RolesEntity rolesEntity);

    /**
     * 批量插入
     *
     * @param rolesEntitys List<RolesEntity>
     * @return int
     */
    int insertList(@Param("rolesEntitys") List<RolesEntity> rolesEntitys);

    /**
     * 主键更新
     *
     * @param rolesEntity RolesEntity
     * @return int
     */
    int updateByPrimaryKeySelective(@Param("rolesEntity") RolesEntity rolesEntity);

    /**
     * 根据id批量查询
     *
     * @param list List<Long>
     * @return List<RolesEntity>
     */
    List<RolesEntity> selectByIdList(List<Long> list);
}
