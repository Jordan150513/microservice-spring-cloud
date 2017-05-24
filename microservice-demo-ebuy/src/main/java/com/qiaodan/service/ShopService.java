package com.qiaodan.service;

import com.qiaodan.DAO.ShopMapper;
import com.qiaodan.inmodel.ShopInModel;
import com.qiaodan.model.Shop;
import com.qiaodan.model.ShopExample;
import com.qiaodan.outmodel.BaseOutModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qiaodan on 2017/5/24.
 */
@Service
public class ShopService {
    @Autowired
    private ShopMapper shopMapper;

    public BaseOutModel createshop(ShopInModel model) {
        BaseOutModel baseOutModel = new BaseOutModel();
        Shop shop = new Shop();
        shop.setShopname(model.getShopName());
        shop.setAddress(model.getAddress());
        shop.setEmail(model.getEmail());
        shop.setPhoneno(model.getPhoneNo());
        shop.setUserid(model.getUserid());
        int rs = shopMapper.insertSelective(shop);
        baseOutModel.setCode(rs);
        baseOutModel.setMessage(rs == 1 ? "创建店铺成功！" : "创建店铺失败！");
        return baseOutModel;
    }
    // 查询是否有该shop
    public Shop findShop(Integer shopid){
        return shopMapper.selectByPrimaryKey(shopid);
    }
    // update shop
    public Integer updateShop(Shop shop){
        return shopMapper.updateByPrimaryKeySelective(shop);
    }
}
