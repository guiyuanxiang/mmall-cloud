package com.mmall.admin.shiro;

import com.google.common.collect.Lists;
import com.mmall.admin.pojo.entity.AdminEntity;
import com.mmall.common.util.FilterOutUtil;
import com.mmall.common.util.ServerResponse;
import com.mmall.common.util.SpringUtil;
import jodd.util.StringPool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author gg
 * @version LoginFormFilter.java, v 0.1 2019-01-06 16:02 gg
 */
@Slf4j
public class LoginFormFilter extends FormAuthenticationFilter {

    private static final String SHOP_ID = "ShopId";

    /**
     * 跨域处理
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpResponse.setHeader("Access-control-Allow-Origin", "*");
            httpResponse.setHeader("Access-Control-Allow-Methods", httpRequest.getMethod());
            httpResponse.setHeader("Access-Control-Allow-Headers", httpRequest.getHeader("Access-Control-Request-Headers"));
            httpResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    /**
     * 此处为登陆成功后的 权限校验
     * 此处演示的是 一些url，需要用户有相应得到商铺权限才能操作
     *
     * @param request     ServletRequest
     * @param response    ServletResponse
     * @param mappedValue Object
     * @return boolean
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        boolean result = super.isAccessAllowed(request, response, mappedValue) ||
                (!isLoginRequest(request, response) && isPermissive(mappedValue));
        if (result) {
            HttpServletRequest req = (HttpServletRequest) request;
            AdminMapper adminMapper = SpringUtil.getBean(AdminMapper.class);
            ShiroUser shiroUser = ShiroOperation.getCurrentAdmin();
            AdminEntity adminEntity = adminMapper.selectByLoginName(shiroUser.getUsername());
            String shopIds = adminEntity.getShopIds();
            String shopId = req.getHeader(SHOP_ID).trim();
            if (StringUtils.isBlank(shopId)) {
                ServerResponse error = ServerResponse.createByErrorCodeMessage(1, "必须选择商户");
                FilterOutUtil.out(error, response);
            }
            if (StringUtils.isBlank(shopIds)) {
                ServerResponse error = ServerResponse.createByErrorCodeMessage(1, "用户无权浏览该商户下的页面");
                FilterOutUtil.out(error, response);
            }
            List<String> shopIdList = Lists.newArrayList(shopIds.split(StringPool.COMMA));
            List<Integer> shopIdIntList = Lists.newArrayList();
            shopIdList.forEach(shopIdStr -> {
                shopIdIntList.add(Integer.valueOf(shopIdStr.trim()));
            });
            if (CollectionUtils.isEmpty(shopIdList)) {
                ServerResponse error = ServerResponse.createByErrorCodeMessage(1, "用户无权浏览该商户下的页面!!");
                FilterOutUtil.out(error, response);
            }
            if (!shopIdIntList.contains(Integer.valueOf(shopId))) {
                //用感叹号的数量区分报错位置
                ServerResponse error = ServerResponse.createByErrorCodeMessage(1, "用户无权浏览该商户下的页面!!!");
                FilterOutUtil.out(error, response);
            }
            return true;
        }
        return false;
    }

    /**
     * 未登陆处理 前后端分离方案
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                return executeLogin(request, response);
            } else {
                return true;
            }
        } else {
            ServerResponse error = ServerResponse.createByErrorCodeMessage(1, "请先进行登录!!");
            FilterOutUtil.out(error, response);
            return false;
        }
    }


}