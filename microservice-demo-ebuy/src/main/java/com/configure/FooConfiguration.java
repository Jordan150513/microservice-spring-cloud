package com.configure;

import feign.Contract;
import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by qiaodan on 2017/5/18.
 */
@Component
@Configuration
public class FooConfiguration {
    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FATAL;
    }
}
