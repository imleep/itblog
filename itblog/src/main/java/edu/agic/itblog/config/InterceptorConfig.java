package edu.agic.itblog.config;

import edu.agic.itblog.interceptor.AllowOriginInterceptor;
import edu.agic.itblog.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/27 2:33
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    private AllowOriginInterceptor allowOriginInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(allowOriginInterceptor)
                .addPathPatterns("/**");

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/login/**")
                .excludePathPatterns("/user/regist")
                .excludePathPatterns("/**/api/**")
                .excludePathPatterns("/file/download")
                .excludePathPatterns("/file/upload/avatar");

    }
}
