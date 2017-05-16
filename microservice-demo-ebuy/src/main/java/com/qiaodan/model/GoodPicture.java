package com.qiaodan.model;

public class GoodPicture {
    private Integer id;

    private String goodname;

    private String goodcolor;

    private String goodpicture;

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

    public String getGoodpicture() {
        return goodpicture;
    }

    public void setGoodpicture(String goodpicture) {
        this.goodpicture = goodpicture == null ? null : goodpicture.trim();
    }
}