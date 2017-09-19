package com.itmei.prototype;

/**
 * Created by qiaodan on 2017/9/14.
 */
public class Robot  implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public  Robot(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
