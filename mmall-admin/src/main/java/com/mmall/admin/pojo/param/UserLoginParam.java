package com.mmall.admin.pojo.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author gg
 * @version UserLoginParam.java, v 0.1 2019-04-29 11:42 gg
 */
@Data
public class UserLoginParam implements Serializable {

    @NotBlank(message = "用户名不能为空")
    private String loginName;

    @NotBlank(message = "登陆密码不能为空")
    private String loginPassword;
}