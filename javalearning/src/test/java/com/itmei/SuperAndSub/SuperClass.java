package com.itmei.SuperAndSub;

/**
 * Created by qiaodan on 17/9/19.
 */
public class SuperClass {

    public SuperClass(){
        overrideMe();
        System.out.print("父类构造函数被调用了");
    }

    public void overrideMe(){

        System.out.print("父类的构造方法调用了一个普通方法 被调用了");
    }
}
