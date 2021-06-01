package com.lzcoke.config;


import com.lzcoke.utils.RedisUtils;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class LoginHandleInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    @ApiModelProperty(hidden = false)
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null) {
            // 未登录
            request.setAttribute("msg", "未登录账号，请登录");
            request.getRequestDispatcher("/500").forward(request, response);
            return false;
        } else {
            Object o = redisUtils.get("token_" + token);
            if (o == null) {
                // 未登录
                request.setAttribute("msg", "验证失败，请登录");
                request.getRequestDispatcher("/500").forward(request, response);
                return false;
            } else {
                return true;
            }
        }
    }
}
