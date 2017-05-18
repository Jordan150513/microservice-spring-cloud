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
    }
}
