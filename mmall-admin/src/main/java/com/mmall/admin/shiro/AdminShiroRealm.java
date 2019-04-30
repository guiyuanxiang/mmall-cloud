package com.mmall.admin.shiro;

import com.mmall.admin.pojo.entity.AdminEntity;
import com.mmall.admin.pojo.entity.ResourceEntity;
import com.mmall.admin.pojo.entity.RolesEntity;
import com.mmall.admin.pojo.param.UserLoginParam;
import com.mmall.admin.pojo.result.UserPermissionResult;
import com.mmall.admin.service.AdminService;
import jodd.util.StringPool;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Set;


/**
 * @author gg
 * @version MyShiroReal.java, v 0.1 2018-05-31 16:24 caofy
 */
public class AdminShiroRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminShiroRealm.class);

    @Resource
    private AdminService adminService;

    /**
     * 授权用户权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        ShiroUser user = (ShiroUser) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        UserPermissionResult userPermissionResult = adminService.getPermissionByUserName(user.getUsername());
        Set<RolesEntity> roles = userPermissionResult.getRolesEntitySet();
        for (RolesEntity rolesEntity : roles) {
            authorizationInfo.addRole(rolesEntity.getName());
            Set<ResourceEntity> resources = userPermissionResult.getResourceEntitySet();
            for (ResourceEntity resourceEntity : resources) {
                authorizationInfo.addStringPermission(resourceEntity.getCode());
            }
        }
        return authorizationInfo;
    }


    /**
     * 验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws ShiroException {
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;
        String userName = token.getUsername();
        String password = String.valueOf(token.getPassword());
        LOGGER.info("doGetAuthenticationInfo execute, username={}", userName);
        //设置session超时时间
        UserLoginParam userLoginParam = new UserLoginParam();
        userLoginParam.setLoginName(userName);
        userLoginParam.setLoginPassword(password);
        ShiroOperation.setSessionExpirationTime(ShiroConfig.SESSION_EXPIRE_TIME);
        AdminEntity adminEntity = adminService.getUserByLoginName(userName);
        if (adminEntity == null) {
            throw new AuthenticationException("用户名错误");
        }
        if (!adminEntity.getLoginPassword().equals(password)) {
            throw new AuthenticationException("密码错误");
        }
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setUsername(adminEntity.getLoginName());
        shiroUser.setPassword(adminEntity.getLoginPassword());
        shiroUser.setRoleIds(adminEntity.getRoleIds());
        return new SimpleAuthenticationInfo(shiroUser, password, getName());
    }

}
