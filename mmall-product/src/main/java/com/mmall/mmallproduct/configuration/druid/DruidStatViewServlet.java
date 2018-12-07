package com.mmall.mmallproduct.configuration.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author: gg
 * @date: 2018/12/7 11:32
 */
@WebServlet(urlPatterns = {"/druid/*"},
        initParams = {@WebInitParam(name = "loginUsername", value = "admin"),
                @WebInitParam(name = "loginPassword", value = "admin")})
public class DruidStatViewServlet extends StatViewServlet {

}