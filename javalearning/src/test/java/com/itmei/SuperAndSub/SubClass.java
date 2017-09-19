package com.itmei.SuperAndSub;

import java.util.Date;

/**
 * Created by qiaodan on 17/9/19.
 */
public final class SubClass extends SuperClass{
    private final Date date;

    public SubClass(){
        date = new Date();
        System.out.print("子类的构造方法被调用了 子类构造方法里没有调用其他的函数");
    }

    @Override
    public void overrideMe(){
        System.out.print("---------:::"+date);
        System.out.print("子类覆盖父类的方法被调用了");
    }

    // 子类 父类 的调用关系

    // 1、父类构造函数被调用了
    // 2、父类构造方法中调用的方法 被子类覆盖的之后 调用的是子类的方法
    // 3、子类的构造方法被调用了 子类构造方法里没有调用其他的函数

}
