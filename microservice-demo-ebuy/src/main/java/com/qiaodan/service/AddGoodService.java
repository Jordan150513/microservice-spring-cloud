package com.qiaodan.service;

import com.qiaodan.DAO.GoodDetailMapper;
import com.qiaodan.DAO.GoodsBriefMapper;
import com.qiaodan.DAO.GoodsDetailMapper;
import com.qiaodan.inmodel.AddGoodsInModel;
import com.qiaodan.inmodel.SingleGoodInModel;
import com.qiaodan.inmodel.SubInfo;
import com.qiaodan.inmodel.SubInfo;
import com.qiaodan.model.*;
import com.qiaodan.outmodel.BaseOutModel;
import com.qiaodan.outmodel.GoodsListOutModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin.javascript.navig.LinkArray;

import java.util.ArrayList;
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
        if (rs != 1) {
            baseOutModel.setCode(0);
            baseOutModel.setMessage("插入商品失败！");
            return baseOutModel;
        }
        GoodsDetail goodsDetail = new GoodsDetail();
        goodsDetail.setGoodbriefid(goodsBrief.getId());// 这里一直获取不到。。。
        for (int i = 0; i < model.getGoodInfoList().size(); i++) {
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
        if (rs != 1) {
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

    /*
*   这里有一个疑问，就是：
*   在数据库中是按照一个商品确定的尺寸 作为一个商品记录的，但是，我现在要返回的是这样一个形式的数据
*   这个应该如何设计实现?、
*    经过考虑 决定将gooddetail商品表拆分成两个表，会好很多。
* */
    public GoodsListOutModel getGoodsListByShopid(Integer shopId) {
        GoodsListOutModel model = new GoodsListOutModel();

        GoodsBriefExample goodsBriefExample = new GoodsBriefExample();
        GoodsBriefExample.Criteria criteria = goodsBriefExample.createCriteria();
        criteria.andShopidEqualTo(shopId);
        List<GoodsBrief> list =  goodsBriefMapper.selectByExample(goodsBriefExample);

        if (list==null){
            model.setCode(0);
            model.setMessage("没有找到店铺对应的商品列表");
            return model;
        }
        if (list.size()==0){
            model.setCode(1);
            model.setMessage("店铺目前还没有商品");
            return model;
        }

        GoodsOutModel goodsOutModel = new GoodsOutModel();
        for (int i =0;i<list.size();i++){
            GoodsBrief goodsBrief = list.get(i);
            goodsOutModel.setGoodname(goodsBrief.getGoodname());
            goodsOutModel.setId(goodsBrief.getId());
            goodsOutModel.setShopid(goodsBrief.getShopid());
            goodsOutModel.setPictures(goodsBrief.getPictures());

            GoodsDetailExample goodsDetailExample = new GoodsDetailExample();
            GoodsDetailExample.Criteria criteria1 = goodsDetailExample.createCriteria();
            criteria1.andGoodbriefidEqualTo(goodsBrief.getId());
            List<GoodsDetail> goodsDetailList = goodsDetailMapper.selectByExample(goodsDetailExample);
            if (goodsDetailList==null||goodsDetailList.size()==0){
                break;
            }
            List<GoodsDetailOutModel> goodsDetailOutModelList = new ArrayList<GoodsDetailOutModel>();
            for (int j=0;j<goodsDetailList.size();j++){
                GoodsDetail goodsDetail = goodsDetailList.get(j);
                GoodsDetailOutModel goodsDetailOutModel = new GoodsDetailOutModel();

                goodsDetailOutModel.setId(goodsDetail.getId());
                goodsDetailOutModel.setGoodcolor(goodsDetail.getGoodcolor());
                goodsDetailOutModel.setGoodprice(goodsDetail.getGoodprice());
                goodsDetailOutModel.setGoodsize(goodsDetail.getGoodsize());
                goodsDetailOutModel.setGoodremaincount(goodsDetail.getGoodremaincount());
                goodsDetailOutModel.setPictures(goodsDetail.getPictures());
                goodsDetailOutModelList.add(goodsDetailOutModel);
            }
            goodsOutModel.setList(goodsDetailOutModelList);

            if (model.getGoodsOutModelList()==null){
                List<GoodsOutModel> goodsOutModelList = new ArrayList<GoodsOutModel>();
                goodsOutModelList.add(goodsOutModel);
                model.setGoodsOutModelList(goodsOutModelList);
            }else {
                model.getGoodsOutModelList().add(goodsOutModel);
            }

        }
        model.setCode(1);
        model.setMessage("获取店铺商品列表成功");
        return model;
    }
}
