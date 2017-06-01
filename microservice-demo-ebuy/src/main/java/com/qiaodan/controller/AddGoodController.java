package com.qiaodan.controller;

import com.qiaodan.DAO.GoodDetailMapper;
import com.qiaodan.inmodel.AddGoodsInModel;
import com.qiaodan.inmodel.SingleGoodInModel;
import com.qiaodan.inmodel.SubInfo;
import com.qiaodan.model.GoodDetail;
import com.qiaodan.outmodel.BaseOutModel;
import com.qiaodan.outmodel.GoodBriefDetailOutModel;
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
@Api(value = "商品-控制器",description = "添加，查询，更改信息")
@RestController
@RequestMapping("/Goods/")
public class AddGoodController {

    @Autowired
    private AddGoodService addGoodService;
    @ApiOperation(value = "添加单个商品",notes = "添加操作")
    @RequestMapping(value = "addSingleGood",method = RequestMethod.GET)
    public BaseOutModel addSingleGood(@RequestBody SingleGoodInModel model){
       return addGoodService.addSingle(model);
    }

    @ApiOperation(value = "添加一批规格的商品",notes = "添加操作")
    @RequestMapping(value = "addGoods",method = RequestMethod.POST)
    public  BaseOutModel addGoods(@RequestBody AddGoodsInModel model){
        return addGoodService.addGoods(model);
    }

    @ApiOperation(value = "获取店铺所有商品列表",notes = "查询操作")
    @RequestMapping(value = "getGoodsListByShopid",method = RequestMethod.GET)
    public GoodsListOutModel getGoodsListByShopid(@RequestParam Integer shopId){

        return addGoodService.getGoodsListByShopid(shopId);
    }

    @ApiOperation(value = "获取某个商品的详细信息",notes = "查询操作")
    @RequestMapping(value = "getGoodById",method = RequestMethod.GET)
    public GoodBriefDetailOutModel getGoodById(@RequestParam Integer goodBriefId){

        return addGoodService.getGoodById(goodBriefId);
    }


    @ApiOperation(value = "获取店铺所有商品列表  用一条sql语句实现",notes = "查询操作")
    @RequestMapping(value = "getGoodsListByShopid2",method = RequestMethod.GET)
    public GoodsListOutModel getGoodsListByShopid2(@RequestParam Integer shopId){

        return addGoodService.getGoodsListByShopid2(shopId);
    }

    @ApiOperation(value = "获取某个商品的详细信息  用一条sql语句实现",notes = "查询操作")
    @RequestMapping(value = "getGoodById2",method = RequestMethod.GET)
    public GoodBriefDetailOutModel getGoodById2(@RequestParam Integer goodBriefId){

        return addGoodService.getGoodById2(goodBriefId);
    }



    @ApiOperation(value = "修改某个商品的详细信息",notes = "更新操作")
    @RequestMapping(value = "updateGood",method = RequestMethod.POST)
    public BaseOutModel updateGood(@RequestBody SubInfo subInfo){
        return addGoodService.updateGood(subInfo);
    }
}
