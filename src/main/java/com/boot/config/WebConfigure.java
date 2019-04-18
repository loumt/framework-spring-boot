package com.boot.config;

import com.boot.intercept.WebRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigure implements WebMvcConfigurer {

    @Autowired
    private WebRequestInterceptor webRequestInterceptor;

    /**
     * 自定义的拦截器在添加注册
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webRequestInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
