package com.itmei.decoration;

/**
 * Created by qiaodan on 2017/9/13.
 */
public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public int makeMoreCandied(){
        return super.makeMoreCandied()+1;
    }

    @Override
    public double getPrice(){
        return super.getPrice()+3d;
    }
}
