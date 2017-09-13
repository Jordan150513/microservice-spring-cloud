package com.itmei.decoration;

/**
 * Created by qiaodan on 2017/9/13.
 */
public abstract class CoffeeDecorator extends Coffee{
    // 抽象的装饰器
    private Coffee coffee;
    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public int makeMoreCandied(){
        return this.coffee.makeMoreCandied();
    }

    @Override
    public double getPrice(){
        return this.coffee.getPrice();
    }

}
