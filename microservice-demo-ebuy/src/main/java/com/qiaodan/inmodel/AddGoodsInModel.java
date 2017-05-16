package com.qiaodan.inmodel;

import java.util.List;

/**
 * Created by qiaodan on 2017/5/11.
 */
public class AddGoodsInModel {
    private String goodName;
//    private List<SubInfo> goodInfoList;
    private SubInfo[] goodInfoArr;

    public SubInfo[] getGoodInfoArr() {
        return goodInfoArr;
    }

    public void setGoodInfoArr(SubInfo[] goodInfoArr) {
        this.goodInfoArr = goodInfoArr;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

//    public List<SubInfo> getGoodInfoList() {
//        return goodInfoList;
//    }
//
//    public void setGoodInfoList(List<SubInfo> goodInfoList) {
//        this.goodInfoList = goodInfoList;
//    }

    public class SubInfo{
        private String goodSize;
        private float goodPrice;
        private String goodColor;
        private Integer goodRemainCount;

        public String getGoodSize() {
            return goodSize;
        }

        public void setGoodSize(String goodSize) {
            this.goodSize = goodSize;
        }

        public float getGoodPrice() {
            return goodPrice;
        }

        public void setGoodPrice(float goodPrice) {
            this.goodPrice = goodPrice;
        }

        public String getGoodColor() {
            return goodColor;
        }

        public void setGoodColor(String goodColor) {
            this.goodColor = goodColor;
        }

        public Integer getGoodRemainCount() {
            return goodRemainCount;
        }

        public void setGoodRemainCount(Integer goodRemainCount) {
            this.goodRemainCount = goodRemainCount;
        }

        public SubInfo(String goodSize, float goodPrice, String goodColor, Integer goodRemainCount) {
            this.goodSize = goodSize;
            this.goodPrice = goodPrice;
            this.goodColor = goodColor;
            this.goodRemainCount = goodRemainCount;
        }

        public SubInfo() {
        }
    }
}

