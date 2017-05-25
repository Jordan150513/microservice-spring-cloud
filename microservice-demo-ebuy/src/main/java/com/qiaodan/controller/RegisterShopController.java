package com.qiaodan.controller;

import com.qiaodan.inmodel.ShopInModel;
import com.qiaodan.model.Shop;
import com.qiaodan.outmodel.BaseOutModel;
import com.qiaodan.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2017/5/24.
 */
@RestController
@RequestMapping("Shop")
@Api(value = "店铺-控制器", description = "创建，修改信息")
public class RegisterShopController {
    @Autowired
    private ShopService shopService;

    // 登陆之后 注册店铺
    @ApiOperation(value = "注册 创建 店铺", notes = "用户注册创建店铺")
    @RequestMapping(value = "RegisterShop", method = RequestMethod.POST)
    public BaseOutModel createshop(@RequestBody ShopInModel model) {
        BaseOutModel baseOutModel = shopService.createshop(model);
        return baseOutModel;
    }

    @ApiOperation(value = "注册 创建 店铺", notes = "用户修改店铺信息")
    @RequestMapping(value = "updateShopDetail", method = RequestMethod.POST)
    public BaseOutModel updateShopDetail(@RequestBody Shop model) {

        BaseOutModel baseOutModel = new BaseOutModel();
        Shop shop1 = shopService.findShop(model.getId());
        if (shop1 == null) {
            baseOutModel.setMessage("ouch！出错了，没有该店铺记录！");
            baseOutModel.setCode(0);
            return baseOutModel;
        }
        int rs = shopService.updateShop(model);
        if (rs!=1){
            baseOutModel.setMessage("ouch！出错了，修改店铺信息失败了！");
            baseOutModel.setCode(0);
            return baseOutModel;
        }
        baseOutModel.setMessage("修改店铺信息成功！");
        baseOutModel.setCode(0);
        return baseOutModel;
    }

}
