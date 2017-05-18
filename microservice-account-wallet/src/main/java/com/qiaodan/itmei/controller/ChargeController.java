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
//@RequestMapping("/ChargeController/")
@Api(value = "ChargeController",description = "钱包充值中心")
public class ChargeController {
//  http://localhost:7979/wallet/ChargeController/chargeForUser
    @ApiOperation(value = "chargeForUser",notes = "为某个用户充值")
    @RequestMapping(value = "/ChargeController/chargeForUser",method = RequestMethod.GET)
    public String chargeForUser(){
        return "charge+1";
    }
}
