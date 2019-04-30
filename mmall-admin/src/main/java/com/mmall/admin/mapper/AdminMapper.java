package com.mmall.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.mmall.admin.pojo.entity.AdminEntity;

/**
 * @author guigu
 */
@Mapper
public interface AdminMapper {

    /**
     * 选择插入
     *
     * @param adminEntity AdminEntity
     * @return int
     */
    int insertSelective(@Param("adminEntity") AdminEntity adminEntity);

    /**
     * 批量插入
     *
     * @param adminEntitys List<AdminEntity>
     * @return int
     */
    int insertList(@Param("adminEntitys") List<AdminEntity> adminEntitys);

    /**
     * 选择更新
     *
     * @param adminEntity AdminEntity
     * @return int
     */
    int updateByPrimaryKeySelective(@Param("adminEntity") AdminEntity adminEntity);

    /**
     * 根据登录名查询
     *
     * @param loginName 登录名
     * @return AdminEntity
     */
    AdminEntity selectByLoginName(String loginName);
}
