package com.itmei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by qiaodan on 2017/7/13.
 */

@RestController
@RequestMapping("test")
public class BaseController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${servicePath}")
    private String servicePath;
//
//    @RequestMapping(name = "consumer/",method = RequestMethod.GET)
//    public String consumer(){
//        return this.restTemplate.getForObject(this.servicePath,String.class);
//    }

    @RequestMapping(value = "getName",method = RequestMethod.GET)
    public String getUser(){
        return "from client-provider-1-user";
    }

    @RequestMapping(value = "getName2",method = RequestMethod.GET)
    public String getUser2(){
        return this.restTemplate.getForObject(this.servicePath,String.class);
    }

}
