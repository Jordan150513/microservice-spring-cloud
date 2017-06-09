package com.qiaodan.controller;

import com.qiaodan.inmodel.AddReceiverAddressInmodel;
import com.qiaodan.outmodel.BaseOutModel;
import com.qiaodan.service.AddGoodService;
import com.qiaodan.service.ReceiverAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2017/6/9.
 */


@Api(value = "收货人控制器",description="收获地址相关接口")
@RestController
@RequestMapping("ReceiverAddress")
public class ReceiverAddressController {

    @Autowired
    private ReceiverAddressService receiverAddressService;

    @RequestMapping(value = "AddReceiverAddress",method = RequestMethod.POST)
    public BaseOutModel AddReceiverAddress(@RequestBody AddReceiverAddressInmodel inmodel){
        BaseOutModel outModel =  new BaseOutModel();
        try {
            outModel =  receiverAddressService.AddReceiverAddress(inmodel,outModel);
        }catch (Exception e){
            outModel.setCode(0);
            outModel.setMessage("请求失败，请稍后重试"+e.getMessage());
        }
        return outModel;
    }
}
