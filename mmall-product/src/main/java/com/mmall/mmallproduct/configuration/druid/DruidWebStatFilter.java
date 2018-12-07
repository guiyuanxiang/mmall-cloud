package com.mmall.mmallproduct.configuration.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author: gg
 * @date: 2018/12/7 11:30
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = { @WebInitParam(name = "exclusions",
                value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*") })
public class DruidWebStatFilter extends WebStatFilter {

}