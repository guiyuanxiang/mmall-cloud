package com.mmall.admin.shiro;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gg
 * @version CorsFilter.java, v 0.1 2019-04-29 14:52 gg
 */
@Component
public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        httpServletResponse.setContentType("text/html;charset=UTF-8");

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");

        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");

        httpServletResponse.setHeader("Access-Control-Max-Age", "0");

        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");

        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

        httpServletResponse.setHeader("XDomainRequestAllowed","1");

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}