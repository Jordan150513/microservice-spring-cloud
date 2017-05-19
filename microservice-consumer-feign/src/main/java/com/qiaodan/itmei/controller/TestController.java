package com.qiaodan.itmei.controller;

import com.qiaodan.itmei.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2017/5/18.
 */
@RestController
@RequestMapping(value = "TestController",method = RequestMethod.GET)
public class TestController {
    @Autowired
    private TestService testService;
//  localhost:8877/TestController/testFeign/
    @RequestMapping(value = "/testFeign",method = RequestMethod.GET)
    public String testFeign(){
        return testService.test();
//        return  formatterTotal("12345678888888");
    }

    // 当年如此简单的东西 都没有写好
    public String formatterTotal(String str){

        if (str.length()<4) return str;
        for (int i =str.length();i>0;i=i-3){
            str = str.substring(0,i)+","+str.substring(i);
        }
        return str;
    }
}
