package com.qiaodan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2017/5/8.
 */
@RequestMapping("/demo/TestController/")
@RestController
public class TestController {

    // 请求url： http://localhost:8080/demo/TestController/sayHello?word=qiao
    // 更改配置之后的 http://localhost:9090/QD/demo/TestController/sayHello?word=qiao
    @RequestMapping("sayHello")
    public String sayHello(String word){
        return "Hello "+ word;
    }
}
