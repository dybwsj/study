package com.self.study.component;

import cn.hutool.json.JSONUtil;
import com.self.study.common.ResultVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: duyubo
 * @date: 2020年11月25日, 0025 10:12
 * @description:
 *   spring security默认有一个filter拦截logout路径的请求
 *  正常的流程: 该handler是处理注销之后的业务逻辑，如删除session等
 *  然后实现一个security提供的LogoutSuccessHandler 并将其配置到security的config中，以此来处理返回信息
 */
public class RestfulLogoutHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Cache-Control","no-cache");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        try {
            httpServletResponse.getWriter().println(JSONUtil.parse(ResultVO.success(null)));
            httpServletResponse.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
