package com.itmei.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2017/7/7.
 */
@RestController
@RefreshScope
@RequestMapping("test")
@EnableEurekaClient
public class TestController {

    @Value("${name}")
    private String name;

    @RequestMapping(value = "fetchName",method = RequestMethod.GET)
    public String fetchName(){
     return this.name;
    }

    @RequestMapping(value = "getName",method = RequestMethod.GET)
    public String getUser(){
        return "from client-provider-1-user";
    }

}

