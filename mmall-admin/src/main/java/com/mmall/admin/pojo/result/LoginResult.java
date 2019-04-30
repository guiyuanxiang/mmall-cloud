package com.mmall.admin.pojo.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gg
 * @version LoginResult.java, v 0.1 2019-04-30 16:30 gg
 */
@Data
public class LoginResult implements Serializable {

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
     * 最后登陆日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginAt;

}