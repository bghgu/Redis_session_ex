package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ds on 2018-03-26.
 */

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Interceptor interceptor;

    /**
     * 인터셉터 검사에서 제외시킬 url
     */
    private static final String[] EXCLUDE_PATH = {
            "/",
            "/login",
            "/login-processing"
    };

    /**
     * 인터셉터 등록
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(EXCLUDE_PATH);
    }
}
