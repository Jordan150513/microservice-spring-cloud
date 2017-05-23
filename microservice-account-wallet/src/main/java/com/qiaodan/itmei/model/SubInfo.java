package com.qiaodan.itmei.model;

/**
 * Created by qiaodan on 2017/5/23.
 */
public class SubInfo {
    private String goodSize;
    private float goodPrice;
    private String goodColor;
    private Integer goodRemainCount;

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

    public String getGoodColor() {
        return goodColor;
    }

    public void setGoodColor(String goodColor) {
        this.goodColor = goodColor;
    }

    public Integer getGoodRemainCount() {
        return goodRemainCount;
    }

    public void setGoodRemainCount(Integer goodRemainCount) {
        this.goodRemainCount = goodRemainCount;
    }
}
