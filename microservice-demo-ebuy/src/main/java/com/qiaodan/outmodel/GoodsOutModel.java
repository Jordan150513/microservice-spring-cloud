package com.qiaodan.outmodel;

import java.util.List;

/**
 * Created by qiaodan on 2017/5/25.
 */
public class GoodsOutModel {
    private Integer id;
    private String goodname;
    private Integer shopid;
    private Integer pictures;

    private List<GoodsDetailOutModel> list;

    public List<GoodsDetailOutModel> getList() {
        return list;
    }

    public void setList(List<GoodsDetailOutModel> list) {
        this.list = list;
    }

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
        this.goodname = goodname;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getPictures() {
        return pictures;
    }

    public void setPictures(Integer pictures) {
        this.pictures = pictures;
    }
}
