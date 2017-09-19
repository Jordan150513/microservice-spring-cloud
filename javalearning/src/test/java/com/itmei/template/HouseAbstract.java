package com.itmei.template;

/**
 * Created by qiaodan on 2017/8/31.
 */
public abstract class HouseAbstract {

    protected abstract void constructFoundations();

    protected abstract void constructWall();

    // template method 模板方法 指定了 方法 实现的步骤 调用的顺序

    public final void construct() {

        constructFoundations();

        constructWall();

    }
}
