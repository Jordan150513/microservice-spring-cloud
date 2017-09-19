package com.itmei.adapter;

/**
 * Created by qiaodan on 2017/9/13.
 */
public class BigDrillBit implements DrillBit {

    @Override
    public void makeBigHole(){
        System.out.println(" BigDrillBit make big hole.");
    }

    @Override
    public void makeSmallHole(){
        System.out.println("sorry! BigDrillBit can only make big hole.");
    }
}
