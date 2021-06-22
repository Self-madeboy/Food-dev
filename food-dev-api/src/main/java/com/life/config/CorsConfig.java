package com.life.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jc
 */
@WebFilter
public class CorsConfig implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(req, res);
    }
}









//    public CorsConfig() {
//    }

//    @Bean
//    public CorsFilter corsFilter() {
        // 1. 添加cors配置信息
//        CorsConfiguration config = new CorsConfiguration();
//            config.addAllowedOrigin("http://localhost:8080");
//        config.addAllowedOrigin("http://shop.z.mukewang.com:8080");
//        config.addAllowedOrigin("http://center.z.mukewang.com:8080");
//        config.addAllowedOrigin("http://shop.z.mukewang.com");
//        config.addAllowedOrigin("http://center.z.mukewang.com");
//        config.addAllowedOrigin("*");
        // 设置是否发送cookie信息
//        config.setAllowCredentials(true);
        // 设置允许请求的方式
//        config.addAllowedMethod("*");
        // 设置允许的header
//        config.addAllowedHeader("*");
        // 2. 为url添加映射路径
//        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
//        corsSource.registerCorsConfiguration("/**", config);
        // 3. 返回重新定义好的corsSource
//        return new CorsFilter(corsSource);
//    }

