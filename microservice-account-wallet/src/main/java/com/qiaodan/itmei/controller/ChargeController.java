package com.qiaodan.itmei.controller;

import com.qiaodan.itmei.model.AddGoodsInModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

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

//        return "charge+1 "+string;
        return getmoveInDateStr();
    }

    public String getmoveInDateStr(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int date = Integer.parseInt(formatter.format(new Date()));
        Integer beginDate= date-10000;
        Integer endDate = date+10000;
        String moveInDateStr = "["+beginDate.toString()+","+endDate.toString()+"]";
        return moveInDateStr;
    }
    @RequestMapping("getListOrArr")
    public String getListOrArr(AddGoodsInModel model){
       String name =  model.getGoodName();
      Integer size =  model.getGoodInfoList().size();
      return name+size;
    }

}

