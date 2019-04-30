package com.mmall.admin.pojo.result;

import com.mmall.admin.pojo.entity.ResourceEntity;
import com.mmall.admin.pojo.entity.RolesEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author gg
 * @version UserPermissionResult.java, v 0.1 2019-04-29 17:33 gg
 */
@Data
public class UserPermissionResult implements Serializable {

    private Set<RolesEntity> rolesEntitySet;

    private Set<ResourceEntity> resourceEntitySet;
}