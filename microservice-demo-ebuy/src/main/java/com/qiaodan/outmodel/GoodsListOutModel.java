package com.qiaodan.outmodel;

import com.qiaodan.inmodel.AddGoodsInModel;
import com.qiaodan.inmodel.SubInfo;

import java.util.List;

/**
 * Created by qiaodan on 2017/5/24.
 */
public class GoodsListOutModel extends BaseOutModel {

    private List<AddGoodsInModel> goodsModel;

    public List<AddGoodsInModel> getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(List<AddGoodsInModel> goodsModel) {
        this.goodsModel = goodsModel;
    }
}
