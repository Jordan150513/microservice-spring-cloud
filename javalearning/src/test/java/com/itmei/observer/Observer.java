package com.itmei.observer;

/**
 * Created by qiaodan on 2017/9/14.
 */
public abstract class Observer {

    protected boolean informed;

    public void informAboutEvent() {

        this.informed = true;
    }

    public boolean wasInformed() {

        return this.informed;
    }
}
