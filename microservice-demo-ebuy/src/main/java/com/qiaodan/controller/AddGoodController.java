package com.qiaodan.controller;

import com.qiaodan.DAO.GoodDetailMapper;
import com.qiaodan.inmodel.AddGoodsInModel;
import com.qiaodan.inmodel.SingleGoodInModel;
import com.qiaodan.model.GoodDetail;
import com.qiaodan.outmodel.BaseOutModel;
import com.qiaodan.outmodel.GoodsListOutModel;
import com.qiaodan.service.AddGoodService;
import com.qiaodan.service.LoginService;
import com.sun.tracing.dtrace.Attributes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by qiaodan on 2017/5/11.
 */
@Api(value = "添加商品控制器",description = "添加单个商品，一批商品")
@RestController
@RequestMapping("/AddGoodController/")
public class AddGoodController {

    @Autowired
    private AddGoodService addGoodService;
    //  http://localhost:9090/AddGoodController/addSingleGood?goodName=圣迪奥女裙&goodColor=白&goodPrice=228.0&goodRemainCount=24$goodSize=L
    @ApiOperation(value = "添加单个商品",notes = "操作")
    @RequestMapping(value = "addSingleGood",method = RequestMethod.GET)
    public BaseOutModel addSingleGood(@RequestBody SingleGoodInModel model){
       return addGoodService.addSingle(model);
    }

    @ApiOperation(value = "添加一批规格的商品",notes = "操作")
    @RequestMapping(value = "addGoods",method = RequestMethod.POST)
    public  BaseOutModel addGoods(@RequestBody AddGoodsInModel model){
        return addGoodService.addGoods(model);
    }

    @ApiOperation(value = "获取店铺商品列表",notes = "操作")
    @RequestMapping(value = "getGoodsListByShopid",method = RequestMethod.GET)
    public GoodsListOutModel getGoodsListByShopid(@RequestParam Integer shopId){

        return addGoodService.getGoodsListByShopid(shopId);
    }
}
