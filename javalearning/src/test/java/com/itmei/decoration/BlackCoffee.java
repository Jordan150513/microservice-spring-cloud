package com.itmei.decoration;

/**
 * Created by qiaodan on 2017/9/13.
 */
public class BlackCoffee extends Coffee {

    @Override
    public int makeMoreCandied() {
        return 0;
    }

    @Override
    public double getPrice(){

        return this.price;

    }

}
