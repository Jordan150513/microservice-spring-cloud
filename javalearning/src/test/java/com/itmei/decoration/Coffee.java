package com.itmei.decoration;

/**
 * Created by qiaodan on 2017/9/13.
 */

// 装饰模式:这种设计模式的主要作用是为给定的对象添加补充角色
public abstract class Coffee {

    // 糖含量
    protected int candied=0;

    // 价格
    protected double price=2d;

    // 添加糖的操作
    public abstract int makeMoreCandied();

    public void setPrice(double price){
        this.price+=price;
    }

    public double getPrice(){
        return this.price;
    }
    public int getCandied(){
        return this.candied;
    }

}
