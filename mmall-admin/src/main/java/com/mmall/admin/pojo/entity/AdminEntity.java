package com.mmall.admin.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员
 *
 * @author gg
 * @version AdminEntity.java, v 0.1 2019-04-30 15:43 gg
 */
@Data
public class AdminEntity implements Serializable {

    /**
     * 用户编号
     */
    private Long id;

    /**
     * 对应商户id 因为需求已改为多选 所以存储逗号分隔字符串
     */
    private String shopIds;

    /**
     * 角色编号
     */
    private String roleIds;

    /**
     * 角色名称
     */
    private String roleNames;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    @JsonIgnore
    private String loginPassword;

    /**
     * 所属人
     */
    private String owner;

    /**
     * 状态 正常 1,停用 2
     */
    private Integer state;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 删除标记
     */
    private Integer isDeleted;

    /**
     * 最后登陆日期
     */
    private Date lastLoginAt;

}