package com.mmall.admin.service;

import com.mmall.admin.pojo.entity.AdminEntity;
import com.mmall.admin.pojo.param.UserLoginParam;
import com.mmall.admin.pojo.result.LoginResult;
import com.mmall.admin.pojo.result.UserPermissionResult;

/**
 * @author gg
 * @version AdminService.java, v 0.1 2019-04-30 15:52 gg
 */
public interface AdminService {

    /**
     * 获取用户权限
     *
     * @param userName 用户名
     * @return UserPermissionResult
     */
    UserPermissionResult getPermissionByUserName(String userName);

    /**
     * 根据 用户名查询
     *
     * @param userName 用户名
     * @return AdminEntity
     */
    AdminEntity getUserByLoginName(String userName);

    /**
     * 登陆
     *
     * @param userLoginParam UserLoginParam
     * @return LoginResult
     */
    LoginResult login(UserLoginParam userLoginParam);
}
