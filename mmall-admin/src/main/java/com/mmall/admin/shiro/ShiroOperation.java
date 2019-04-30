package com.mmall.admin.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * 当前用户各种变量获取和操作
 *
 * @author danbin
 */
public class ShiroOperation {
    /**
     * 设置过期时间
     * 单位 ms,设置负数为永不超时
     */
    public static void setSessionExpirationTime(long expireTime) {
        SecurityUtils.getSubject().getSession().setTimeout(expireTime);
    }

    /**
     * 设置缓存
     */
    public static void setCacheParam(String key, Object value) {
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(key, value);
    }

    /**
     * 获取缓存
     */
    public static Object getCacheParam(String key) {
        Session session = SecurityUtils.getSubject().getSession();
        return session.getAttribute(key);
    }

    /**
     * 获取当前管理员角色ID
     */
    public static String getCurrentRoleId() {
        ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        if (shiroUser == null) {
            return null;
        }
        return shiroUser.getRoleIds();
    }

    /**
     * 获取当前管理员名
     */
    public static String getCurrentName() {
        ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        if (shiroUser == null) {
            return null;
        }
        return shiroUser.getUsername();
    }

    /**
     * 获取当前管理员
     */
    public static ShiroUser getCurrentAdmin() {
        ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        if (shiroUser == null) {
            throw new NullPointerException("用户不存在");
        }
        return shiroUser;
    }

    /**
     * 退出
     */
    public static void doLogOut() {
        SecurityUtils.getSubject().logout();
    }


}
