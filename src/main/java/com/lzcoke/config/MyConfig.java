package com.lzcoke.config;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 配置信息
@Configuration
public class MyConfig implements WebMvcConfigurer {

    /*使得login监听器成为spring容器*/
    @Bean
    public LoginHandleInterceptor loginHandlerInterceptor() {
        return new LoginHandleInterceptor();
    }


    // 设置路由拦截
    @Override
    @ApiModelProperty(hidden = false)
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns添加拦截路由
        // excludePathPatterns 不拦截路由设置
        registry.addInterceptor(loginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns(
                "/login",
                "/500",
                "/doc.html",
                "/webjars/**",
                "/webjar/**",
                "/swagger-resources",
                "/swagger-resources/**",
                "/c**",
                "/static/**"
        );
    }
}
