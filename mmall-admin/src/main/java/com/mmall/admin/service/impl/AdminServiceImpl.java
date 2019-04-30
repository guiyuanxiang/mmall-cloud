package com.mmall.admin.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mmall.admin.mapper.AdminMapper;
import com.mmall.admin.mapper.ResourceMapper;
import com.mmall.admin.mapper.RoleResourceMapper;
import com.mmall.admin.pojo.entity.AdminEntity;
import com.mmall.admin.pojo.entity.ResourceEntity;
import com.mmall.admin.pojo.entity.RolesEntity;
import com.mmall.admin.pojo.entity.RolesMapper;
import com.mmall.admin.pojo.param.UserLoginParam;
import com.mmall.admin.pojo.result.LoginResult;
import com.mmall.admin.pojo.result.UserPermissionResult;
import com.mmall.admin.service.AdminService;
import com.mmall.common.enums.BooleanEnum;
import com.mmall.common.enums.UserStateEnum;
import com.mmall.common.util.BeanUtil;
import jodd.util.StringPool;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author gg
 * @version AdminServiceImpl.java, v 0.1 2019-04-30 16:36 gg
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private RolesMapper rolesMapper;

    @Resource
    private ResourceMapper resourceMapper;

    @Resource
    private RoleResourceMapper roleResourceMapper;

    /**
     * 获取用户权限
     *
     * @param userName 用户名
     * @return UserPermissionResult
     */
    @Override
    public UserPermissionResult getPermissionByUserName(String userName) {
        UserPermissionResult userPermissionResult = new UserPermissionResult();
        AdminEntity adminEntity = adminMapper.selectByLoginName(userName);
        String roleIds = adminEntity.getRoleIds();
        List<RolesEntity> roleEntity = getRoleEntity(roleIds);
        Set<RolesEntity> roleEntitySet = Sets.newHashSet(roleEntity);
        userPermissionResult.setRolesEntitySet(roleEntitySet);
        List<ResourceEntity> buttons = getPermissions(adminEntity);
        Set<ResourceEntity> resourceEntitySet = Sets.newHashSet(buttons);
        userPermissionResult.setResourceEntitySet(resourceEntitySet);
        return userPermissionResult;
    }

    private List<ResourceEntity> getPermissions(AdminEntity adminEntity) {
        List<String> roleIdList = Lists.newArrayList(adminEntity.getRoleIds().split(StringPool.COMMA));
        Set<Long> resourceIdSet= Sets.newHashSet();
        roleIdList.forEach(roleId->{
            List<Long> resourceIds = roleResourceMapper.selectByRoleId(Long.parseLong(roleId));
            resourceIdSet.addAll(resourceIds);
        });
        List<Long> resourceIdList = Lists.newArrayList(resourceIdSet);
        List<ResourceEntity> resourceEntityList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(resourceIdList)) {
            resourceEntityList = resourceMapper.selectButton(resourceIdList);
        }
        return resourceEntityList;
    }

    /**
     * 查询用户的角色
     *
     * @param roleIds 角色id
     * @return RolesEntity
     */
    private List<RolesEntity> getRoleEntity(String roleIds) {
        if (StringUtils.isNoneBlank(roleIds)) {
            List<Long> roleIdList = Lists.newArrayList();
            String[] split = roleIds.split(StringPool.COMMA);
            for (String s : split) {
                roleIdList.add(Long.parseLong(s));
            }
            return rolesMapper.selectByIdList(roleIdList);
        }
        return new ArrayList<>();
    }

    /**
     * 根据 用户名查询
     *
     * @param userName 用户名
     * @return AdminEntity
     */
    @Override
    public AdminEntity getUserByLoginName(String userName) {
        return adminMapper.selectByLoginName(userName);
    }

    /**
     * 登陆
     *
     * @param userLoginParam UserLoginParam
     * @return LoginResult
     */
    @Override
    public LoginResult login(UserLoginParam userLoginParam) {
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(userLoginParam.getLoginName(), userLoginParam.getLoginPassword());
        AdminEntity adminEntity = adminMapper.selectByLoginName(userLoginParam.getLoginName());
        if (adminEntity == null) {
            throw new RuntimeException("用户名错误");
        }
        if (UserStateEnum.DisAble_USE.getValue().equals(adminEntity.getState()) || BooleanEnum.TRUE.getValue().equals(adminEntity.getIsDeleted())) {
            throw new RuntimeException("用户状态异常");
        }
        SecurityUtils.getSubject().login(usernamePasswordToken);
        usernamePasswordToken.setRememberMe(true);
        adminEntity.setLastLoginAt(new Date());
        adminMapper.updateByPrimaryKeySelective(adminEntity);
        return BeanUtil.map(adminEntity, LoginResult.class);
    }
}