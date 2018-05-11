package com.itmei.controller;

import com.itmei.common.Exception.BaseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2018/5/11.
 */
@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String testAOP(@RequestParam int code)throws BaseException{
        if (code==1){
            return "SUCCESS";
        }else throw new BaseException("fail") ;
    }
}
