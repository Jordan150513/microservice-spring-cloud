package com.qiaodan.outmodel;

import java.util.List;

/**
 * Created by qiaodan on 2017/5/24.
 */
public class GoodsListOutModel extends BaseOutModel {

    private List<GoodsOutModel> goodsOutModelList;

    public List<GoodsOutModel> getGoodsOutModelList() {
        return goodsOutModelList;
    }

    public void setGoodsOutModelList(List<GoodsOutModel> goodsOutModelList) {
        this.goodsOutModelList = goodsOutModelList;
    }
}
