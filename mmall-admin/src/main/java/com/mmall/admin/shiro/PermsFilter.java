package com.mmall.admin.shiro;

import com.mmall.admin.pojo.entity.ResourceEntity;
import com.mmall.admin.pojo.result.UserPermissionResult;
import com.mmall.admin.service.AdminService;
import com.mmall.common.util.FilterOutUtil;
import com.mmall.common.util.ServerResponse;
import com.mmall.common.util.SpringUtil;
import jodd.util.StringPool;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

/**
 * @author gg
 * @version PermsFilter.java, v 0.1 2019-04-30 13:29 gg
 */
public class PermsFilter extends PermissionsAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        boolean isPermitted = false;
        HttpServletRequest req = (HttpServletRequest) request;
        ShiroUser shiroUser = ShiroOperation.getCurrentAdmin();
        AdminService adminService = SpringUtil.getBean(AdminService.class);
        UserPermissionResult userPermissionResult = adminService.getPermissionByUserName(shiroUser.getUsername());
        Set<ResourceEntity> resourceEntitySet = userPermissionResult.getResourceEntitySet();
        String requestUrl = req.getRequestURL().toString();
        for (ResourceEntity resourceEntity : resourceEntitySet) {
            //这里的校验逻辑是 resource表的code字段存的是url的 后几位部分 例如 /admin/login
            String url = resourceEntity.getCode().replace(StringPool.UNDERSCORE, StringPool.SLASH);
            boolean contains = requestUrl.contains(url);
            if (contains) {
                isPermitted = true;
            }
        }
        if (!isPermitted) {
            ServerResponse error = ServerResponse.createByErrorCodeMessage(1, "无权限，请联系管理员!!");
            FilterOutUtil.out(error, response);
        }
        return isPermitted;
    }


}