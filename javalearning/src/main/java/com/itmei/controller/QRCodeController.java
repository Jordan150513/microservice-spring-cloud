package com.itmei.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by qiaodan on 2017/8/24.
 */
@RestController
@RequestMapping("/test/")
public class QRCodeController {

    @RequestMapping("tets01/")
//  @com.fang.home.TargetDataSource("")
    // 并不能成功使用
    public String test01(){
        return "";
    }

}
