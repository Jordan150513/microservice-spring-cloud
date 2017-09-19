package com.itmei.adapter;

/**
 * Created by qiaodan on 2017/9/13.
 */
public class Drill implements HoleMaker {
    // adapter 类  适配器 类
    private DrillBit drillBit;

    public Drill(int diameter) {
        if (isSmall(diameter)) {
            // 小hole
            drillBit = new SmallDrillBit();
        } else {
            // 大hole
            drillBit = new BigDrillBit();
        }
    }

    @Override
    public void makeHole(int diameter) {
        if (isSmall(diameter)) {
            drillBit.makeSmallHole();
        } else {
            drillBit.makeBigHole();
        }
    }

    public boolean isSmall(int diameter) {
        if (diameter < 10) return true;
        else return false;
    }
}
