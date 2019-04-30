package com.mmall.admin.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色 权限关系
 *
 * @author gg
 * @version RoleResourceEntity.java, v 0.1 2019-04-30 17:15 gg
 */
@Data
public class RoleResourceEntity implements Serializable {

    private Long id;

    private Long roleId;

    private Long resourceId;

    private Integer isDeleted;

    private Date createTime;

    private Date updateTime;
}