package com.itmei.template;

/**
 * Created by qiaodan on 2017/8/31.
 */
public class EcologicalHouse extends HouseAbstract {

    @Override
    protected void constructFoundations() {

        System.out.println("Making foundations with wood");

    }

    @Override
    protected void constructWall() {

        System.out.println("Making wall with wood");

    }
}
