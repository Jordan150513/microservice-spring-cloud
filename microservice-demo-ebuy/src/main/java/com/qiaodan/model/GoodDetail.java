package com.qiaodan.model;

public class GoodDetail {
    private Integer id;

    private String goodname;

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

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname == null ? null : goodname.trim();
    }

    public String getGoodcolor() {
        return goodcolor;
    }

    public void setGoodcolor(String goodcolor) {
        this.goodcolor = goodcolor == null ? null : goodcolor.trim();
    }

    public String getGoodsize() {
        return goodsize;
    }

    public void setGoodsize(String goodsize) {
        this.goodsize = goodsize == null ? null : goodsize.trim();
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