package com.itmei.adapter;

/**
 * Created by qiaodan on 2017/9/13.
 */
public class SmallDrillBit implements DrillBit {
    @Override
    public void makeBigHole(){
        System.out.println("sorry! SmallDrillBit can only make small hole.");
    }

    @Override
    public void makeSmallHole(){
        System.out.println("SmallDrillBit  make small hole.");
    }
}
