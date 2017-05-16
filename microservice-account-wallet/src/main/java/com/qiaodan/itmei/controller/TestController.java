package com.qiaodan.itmei.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2017/5/16.
 */
@RestController
@RequestMapping("/TestController/")
@Api(value = "wallet的TestController",description = "test controller")
public class TestController {
//
    @RequestMapping(value = "getTestMessage",method = RequestMethod.GET)
    public String getTestMessage(String message){
        return "Hello "+message;
    }
}
