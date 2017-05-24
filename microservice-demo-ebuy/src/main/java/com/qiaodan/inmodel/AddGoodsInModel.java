package com.qiaodan.inmodel;

import java.util.List;

/**
 * Created by qiaodan on 2017/5/11.
 */
public class AddGoodsInModel {

    private String goodName;
    private List<SubInfo> goodInfoList;
    private Integer shopId;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public List<SubInfo> getGoodInfoList() {
        return goodInfoList;
    }

    public void setGoodInfoList(List<SubInfo> goodInfoList) {
        this.goodInfoList = goodInfoList;
    }

}

