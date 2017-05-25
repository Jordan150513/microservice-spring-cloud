package com.qiaodan.model;

/**
 * Created by qiaodan on 2017/5/25.
 */
public class GoodsDetailOutModel {
    private Integer id;

    private String goodcolor;

    private String goodsize;

    private Float goodprice;

    private Integer goodremaincount;

    private Integer pictures;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodcolor() {
        return goodcolor;
    }

    public void setGoodcolor(String goodcolor) {
        this.goodcolor = goodcolor;
    }

    public String getGoodsize() {
        return goodsize;
    }

    public void setGoodsize(String goodsize) {
        this.goodsize = goodsize;
    }

    public Float getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(Float goodprice) {
        this.goodprice = goodprice;
    }

    public Integer getGoodremaincount() {
        return goodremaincount;
    }

    public void setGoodremaincount(Integer goodremaincount) {
        this.goodremaincount = goodremaincount;
    }

    public Integer getPictures() {
        return pictures;
    }

    public void setPictures(Integer pictures) {
        this.pictures = pictures;
    }
}
