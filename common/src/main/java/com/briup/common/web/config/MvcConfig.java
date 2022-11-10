package com.briup.common.web.config;

import com.briup.common.web.web.interceptor.JwtInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/9/2022-11-09-10:49 AM
 * @Description：com.briup.common.web.config
 */
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcAutoConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/config/**");
    }
}
