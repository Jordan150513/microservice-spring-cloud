package com.itmei.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2017/9/7.
 */
@RestController
@RequestMapping("/test/")
public class TestController {
    @RequestMapping(value = "one/",method = RequestMethod.GET)
    public String test(){
        return "hello docker!";
    }
}
