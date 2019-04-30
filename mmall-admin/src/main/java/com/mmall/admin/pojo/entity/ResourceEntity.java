package com.mmall.admin.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限
 *
 * @author guigu
 */
@Data
public class ResourceEntity implements Serializable {

    /**
	* 主键
	*/
    private Long id;

    /**
	* 等级 1-一级菜单 2-二级菜单 3-按钮
	*/
    private Integer level;

    /**
	* 
	*/
    private Long parentId;

    /**
	* 名称
	*/
    private String name;

    /**
	* 请求资源id
	*/
    private Long actionId;

    /**
	* 编码
	*/
    private String code;

    /**
	* 图标
	*/
    private String icon;

    /**
	* 链接
	*/
    private String url;

    /**
	* 排序
	*/
    private Integer sort;


    /**
	* 展示图标
	*/
    private String displayIcon;

    /**
	* 是否删除 0-未删除 1-已删除
	*/
    private Integer isDeleted;

    /**
	* 创建时间
	*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
	* 更新时间
	*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}