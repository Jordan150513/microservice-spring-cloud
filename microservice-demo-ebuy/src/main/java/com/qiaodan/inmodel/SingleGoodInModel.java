package com.qiaodan.inmodel;

/**
 * Created by qiaodan on 2017/5/11.
 */
public class SingleGoodInModel {
    private String goodName;
    private String goodColor;
    private String goodSize;
    private float goodPrice;
    private Integer goodRemainCount;

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

    public String getGoodColor() {
        return goodColor;
    }

    public void setGoodColor(String goodColor) {
        this.goodColor = goodColor;
    }

    public String getGoodSize() {
        return goodSize;
    }

    public void setGoodSize(String goodSize) {
        this.goodSize = goodSize;
    }

    public float getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(float goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Integer getGoodRemainCount() {
        return goodRemainCount;
    }

    public void setGoodRemainCount(Integer goodRemainCount) {
        this.goodRemainCount = goodRemainCount;
    }
}
