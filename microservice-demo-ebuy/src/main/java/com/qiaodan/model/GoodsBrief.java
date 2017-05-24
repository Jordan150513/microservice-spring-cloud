package com.qiaodan.model;

public class GoodsBrief {
    private Integer id;

    private String goodname;

    private Integer pictures;

    private Integer shopid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname == null ? null : goodname.trim();
    }

    public Integer getPictures() {
        return pictures;
    }

    public void setPictures(Integer pictures) {
        this.pictures = pictures;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }
}