package com.mmall.admin.controller;

import com.mmall.admin.pojo.param.UserLoginParam;
import com.mmall.admin.service.AdminService;
import com.mmall.common.util.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gg
 * @version AdminController.java, v 0.1 2019-04-30 16:25 gg
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/admin/")
public class AdminController {

    @Resource
    private AdminService adminService;


    /**
     * 登陆
     *
     * @param userLoginParam UserLoginParam
     * @return ServerResponse
     */
    @PostMapping("login")
    public ServerResponse login(UserLoginParam userLoginParam) {
        return ServerResponse.createBySuccess(adminService.login(userLoginParam));
    }

    /**
     * 退出登录
     *
     * @return ServerResponse
     */
    @PostMapping("logout")
    public ServerResponse logout() {
        SecurityUtils.getSubject().logout();
        return ServerResponse.createBySuccess();
    }


}