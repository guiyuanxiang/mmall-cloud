package com.mmall.admin.pojo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guigu
 */
@Data
public class RolesEntity implements Serializable {

    /**
     * 角色编号
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 创建日期
     */
    @JSONField(serialize = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;

    /**
     * 更新日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updated;

    /**
     * 删除标记
     */
    @JSONField(serialize = false)
    private Integer isDeleted;
}
