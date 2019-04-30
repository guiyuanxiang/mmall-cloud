package com.mmall.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author gg
 * @version FilterOutUtil.java, v 0.1 2019-04-30 14:04 gg
 */
@Slf4j
public class FilterOutUtil {

    public static void out(ServerResponse error, ServletResponse response) {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        try {
            out = res.getWriter();
            JSONObject errJson = JSONObject.parseObject(JSON.toJSONString(error));
            out.write(errJson.toString());
            out.flush();
            out.close();
        } catch (IOException e) {
            log.error("admin perms error:{}", e);
            e.printStackTrace();
        }
    }
}