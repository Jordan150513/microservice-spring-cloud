package com.itmei.factory;

/**
 * Created by qiaodan on 2017/8/31.
 */
public class Meal {
    private String type;

    public Meal(String type){
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public static Meal valueOf(String ingredient){
        if (ingredient.equals("banana")) {
            return new Meal("fruit");
        }

        return new Meal("vegetable");
    }
}
