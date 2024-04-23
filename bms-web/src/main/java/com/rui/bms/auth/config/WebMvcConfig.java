package com.rui.bms.auth.config;

import com.rui.bms.auth.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 鉴权拦截器配置类
 *
 * @author rui
 * @since 2024-04-22
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .excludePathPatterns(
                        "/swagger-ui/index.html",
                        "/swagger-resources/**",
                        "/v3/api-docs"
                );
    }

}
