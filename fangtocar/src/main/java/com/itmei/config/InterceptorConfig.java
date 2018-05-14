package com.itmei.config;

import com.itmei.fillter.VerificationSignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by qiaodan on 2018/5/14.
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Bean
    VerificationSignInterceptor getAccountInterceptor(){ //使用Bean 注解，不然使用时不能自动注入
        return  new VerificationSignInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // registry.addInterceptor(new HeaderInterceptor()).addPathPatterns("/**") 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(getAccountInterceptor());
        super.addInterceptors(registry);
    }

//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        registry.addResourceHandler("/sh/static/**").addResourceLocations("classpath:/static/");
//
//        super.addResourceHandlers(registry);
//    }

}
