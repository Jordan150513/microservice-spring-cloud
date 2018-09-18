package com.itmei;

/**
 * Created by qiaodan on 2017/8/16.
 */
public class A {
    static {
        System.out.println("ClassA的静态代码块");
    }

    public A() {
        System.out.println("ClassA的构造方法");
    }

    {
        System.out.println("ClassA的构造代码块");
    }
}
