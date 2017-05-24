package com.qiaodan.inmodel;

/**
 * Created by qiaodan on 2017/5/23.
 */
public class SubInfo {
    private String goodSize;
    private float goodPrice;
    private String goodColor;
    private Integer goodRemainCount;

    // 输出 商品列表的时候，需要用到这个
    private Integer goodid;

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
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
