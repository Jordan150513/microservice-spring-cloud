package com.qiaodan.controller;

import com.qiaodan.feign.ChargeFeignClient;
import com.qiaodan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2017/5/8.
 */
@RequestMapping("/demo/TestController/")
@RestController
public class TestController {

private TestService testService;
    // 更改配置之后的 http://localhost:9090/QD/demo/TestController/sayHello?word=qiao
    @RequestMapping("sayHello")
    public String sayHello(String word){
        return "Hello "+ word;
    }

//    // 更改配置之后的 http://localhost:9090/QD/demo/TestController/useFeign
//    @RequestMapping(value = "useFeign",method = RequestMethod.GET)
//    public String useFeign(){
//        return testService.useFeign();
//    }
}
