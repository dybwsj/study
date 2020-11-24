package com.self.study.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: duyubo
 * @date: 2020年11月23日, 0023 17:09
 * @description:
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * addCorsMappings 跨域请求设置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         * addMapping 覆盖所有项目路径
         * allowedOrigins 允许跨域的域名  * 为所有
         * allowCredentials 允许发送cookie
         * allowedMethods 允许的方法
         * allowedHeaders 放行全部原始头信息
         * maxAge 等待时间
         */
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders()
                .maxAge(3600);
    }
}
