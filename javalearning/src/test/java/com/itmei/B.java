package com.itmei;

/**
 * Created by qiaodan on 2017/8/16.
 */
public class B extends A{
    static {
        System.out.println("ClassB的静态代码块");
    }

    public B() {
        System.out.println("ClassB的构造方法");
    }

    {
        System.out.println("ClassB的构造代码块");
    }

    public final static B Classb = new B();

    public void excute(){
        System.out.println("执行方法");
    }
}
