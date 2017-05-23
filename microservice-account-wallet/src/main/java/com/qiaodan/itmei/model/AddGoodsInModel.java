package com.qiaodan.itmei.model;

import java.util.List;

/**
 * Created by qiaodan on 2017/5/11.
 */
public class AddGoodsInModel {

    private String goodName;
    private List<SubInfo> goodInfoList;

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

