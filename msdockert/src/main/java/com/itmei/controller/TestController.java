package com.itmei.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2017/9/11.
 */
@RestController
@RequestMapping("/test/")
public class TestController {
    @RequestMapping("two/")
    public String test(){
        return "____TWO___";
    }
}
