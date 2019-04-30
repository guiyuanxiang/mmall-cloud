package com.mmall.admin.shiro;

import java.io.Serializable;

/**
 * @author gg
 * @version ShiroUser.java, v 0.1 2019-04-29 15:14 gg
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String username;
    private String password;
    private String roleIds;


    public ShiroUser() {
    }

    /**
     * Getter method for property <tt>roleIds</tt>.
     *
     * @return property value of roleIds
     */
    public String getRoleIds() {
        return roleIds;
    }

    /**
     * Setter method for property <tt>roleIds</tt>.
     *
     * @param roleIds value to be assigned to property roleIds
     */
    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}