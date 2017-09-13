package com.itmei.decoration;

/**
 * Created by qiaodan on 2017/9/13.
 */
public class MilkDecorator extends CoffeeDecorator {
    // 实际的 装饰者
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public double getPrice(){
        return super.price+1d;
    }

    @Override
    public int makeMoreCandied(){
        return super.makeMoreCandied()+1;
    }
}
