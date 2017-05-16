package com.qiaodan.service;

import com.qiaodan.DAO.GoodDetailMapper;
import com.qiaodan.inmodel.AddGoodsInModel;
import com.qiaodan.inmodel.SingleGoodInModel;
import com.qiaodan.inmodel.AddGoodsInModel.SubInfo;
import com.qiaodan.model.GoodDetail;
import com.qiaodan.outmodel.BaseOutModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qiaodan on 2017/5/11.
 */
@Service
public class AddGoodService {

    @Autowired
    private GoodDetailMapper goodDetailMapper;

    public BaseOutModel addSingle(SingleGoodInModel model){
        BaseOutModel baseOutModel = new BaseOutModel();
        GoodDetail goodDetail = new GoodDetail();

        goodDetail.setGoodname(model.getGoodName());
        goodDetail.setGoodcolor(model.getGoodColor());
        goodDetail.setGoodprice(model.getGoodPrice());
        goodDetail.setGoodremaincount(model.getGoodRemainCount());
        goodDetail.setGoodsize(model.getGoodSize());

        int rs=0;
        try {
            rs = goodDetailMapper.insertSelective(goodDetail);
        }catch (Exception e){
            e.printStackTrace();
            baseOutModel.setCode(0);
            baseOutModel.setMessage("添加失败！ "+e.toString());
            return  baseOutModel;
        }
        if (rs==1){
            baseOutModel.setCode(1);
            baseOutModel.setMessage("添加成功！");
            return  baseOutModel;
        }
            baseOutModel.setCode(0);
            baseOutModel.setMessage("添加失败！");
            return  baseOutModel;
    }
// 添加一系列的
    public BaseOutModel addGoods(AddGoodsInModel model){
       String goodName =  model.getGoodName();
//        List<AddGoodsInModel.SubInfo> list = model.getGoodInfoList();
//        model.getGoodInfoArr();

        return new BaseOutModel();
    }
}
