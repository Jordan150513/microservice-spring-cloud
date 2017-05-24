package com.qiaodan.service;

import com.qiaodan.DAO.GoodDetailMapper;
import com.qiaodan.DAO.GoodsBriefMapper;
import com.qiaodan.DAO.GoodsDetailMapper;
import com.qiaodan.inmodel.AddGoodsInModel;
import com.qiaodan.inmodel.SingleGoodInModel;
import com.qiaodan.inmodel.SubInfo;
import com.qiaodan.inmodel.SubInfo;
import com.qiaodan.model.GoodDetail;
import com.qiaodan.model.GoodsBrief;
import com.qiaodan.model.GoodsDetail;
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
    private GoodsBriefMapper goodsBriefMapper;
    @Autowired
    private GoodsDetailMapper goodsDetailMapper;

//    public BaseOutModel addSingle(SingleGoodInModel model) {
//        BaseOutModel baseOutModel = new BaseOutModel();
//        GoodDetail goodDetail = new GoodDetail();
//
//        goodDetail.setGoodname(model.getGoodName());
//        goodDetail.setGoodcolor(model.getGoodColor());
//        goodDetail.setGoodprice(model.getGoodPrice());
//        goodDetail.setGoodremaincount(model.getGoodRemainCount());
//        goodDetail.setGoodsize(model.getGoodSize());
//
//        int rs = 0;
//        try {
//            rs = goodDetailMapper.insertSelective(goodDetail);
//        } catch (Exception e) {
//            e.printStackTrace();
//            baseOutModel.setCode(0);
//            baseOutModel.setMessage("添加失败！ " + e.toString());
//            return baseOutModel;
//        }
//        if (rs == 1) {
//            baseOutModel.setCode(1);
//            baseOutModel.setMessage("添加成功！");
//            return baseOutModel;
//        }
//        baseOutModel.setCode(0);
//        baseOutModel.setMessage("添加失败！");
//        return baseOutModel;
//    }

//    // 添加一系列的
//    public BaseOutModel addGoods(AddGoodsInModel model) {
//        BaseOutModel baseOutModel = new BaseOutModel();
//        String goodName = model.getGoodName();
//        List<SubInfo> list = model.getGoodInfoList();
//        GoodDetail goodDetail = new GoodDetail();
//        goodDetail.setGoodname(model.getGoodName());
//        goodDetail.setShopid(model.getShopId());
//        int rs = 0;
//        for (int i = 0; i < list.size(); i++) {
//            SubInfo subInfoI = list.get(i);
//            goodDetail.setGoodcolor(subInfoI.getGoodColor());
//            goodDetail.setGoodprice(subInfoI.getGoodPrice());
//            goodDetail.setGoodremaincount(subInfoI.getGoodRemainCount());
//            goodDetail.setGoodsize(subInfoI.getGoodSize());
//            rs = goodDetailMapper.insertSelective(goodDetail);
//            if (rs != 1) {
//                //插入失败了
//                baseOutModel.setCode(0);
//                baseOutModel.setMessage("插入商品失败！");
//                return baseOutModel;
//            }
//        }
//        baseOutModel.setCode(1);
//        baseOutModel.setMessage("插入商品成功！");
//        return baseOutModel;
//    }

    // 添加一系列的商品
    public BaseOutModel addGoods(AddGoodsInModel model) {
        BaseOutModel baseOutModel = new BaseOutModel();
        GoodsBrief goodsBrief = new GoodsBrief();
        goodsBrief.setShopid(model.getShopId());
        goodsBrief.setGoodname(model.getGoodName());
        int rs = goodsBriefMapper.insertSelective(goodsBrief);
        if (rs!=1){
            baseOutModel.setCode(0);
            baseOutModel.setMessage("插入商品失败！");
            return baseOutModel;
        }
        GoodsDetail goodsDetail = new GoodsDetail();
        goodsDetail.setGoodbriefid(goodsBrief.getId());// 这里一直获取不到。。。
        for (int i=0;i<model.getGoodInfoList().size();i++){
            SubInfo subInfoI = model.getGoodInfoList().get(i);
            goodsDetail.setGoodcolor(subInfoI.getGoodColor());
            goodsDetail.setGoodprice(subInfoI.getGoodPrice());
            goodsDetail.setGoodremaincount(subInfoI.getGoodRemainCount());
            goodsDetail.setGoodsize(subInfoI.getGoodSize());
            rs = goodsDetailMapper.insertSelective(goodsDetail);
            if (rs != 1) {
                //插入失败了
                baseOutModel.setCode(0);
                baseOutModel.setMessage("插入商品失败！");
                return baseOutModel;
            }
        }
        baseOutModel.setCode(1);
        baseOutModel.setMessage("插入商品成功！");
        return baseOutModel;
    }

    public BaseOutModel addSingle(SingleGoodInModel model) {
        BaseOutModel baseOutModel = new BaseOutModel();
        GoodsBrief goodsBrief = new GoodsBrief();
        goodsBrief.setShopid(model.getShopId());
        goodsBrief.setGoodname(model.getGoodName());
        int rs = goodsBriefMapper.insertSelective(goodsBrief);
        if (rs!=1){
            baseOutModel.setCode(0);
            baseOutModel.setMessage("插入商品失败！");
            return baseOutModel;
        }
        GoodsDetail goodsDetail = new GoodsDetail();
        goodsDetail.setGoodbriefid(goodsBrief.getId());
        goodsDetail.setGoodcolor(model.getGoodColor());
        goodsDetail.setGoodprice(model.getGoodPrice());
        goodsDetail.setGoodremaincount(model.getGoodRemainCount());
        goodsDetail.setGoodsize(model.getGoodSize());
        rs = goodsDetailMapper.insertSelective(goodsDetail);
        if (rs != 1) {
            //插入失败了
            baseOutModel.setCode(0);
            baseOutModel.setMessage("插入商品失败！");
            return baseOutModel;
        }
        baseOutModel.setCode(1);
        baseOutModel.setMessage("插入商品成功！");
        return baseOutModel;
    }
//    public List<AddGoodsInModel> getGoodsListByShopid(Integer shopId) {
//        /*
//        *   这里有一个疑问，就是：
//        *   在数据库中是按照一个商品确定的尺寸 作为一个商品记录的，但是，我现在要返回的是这样一个形式的数据
//        *   这个应该如何设计实现?、
 //       *    经过考虑 决定将gooddetail商品表拆分成两个表，会好很多。
//        * */
//        return new List();
//    }
}
