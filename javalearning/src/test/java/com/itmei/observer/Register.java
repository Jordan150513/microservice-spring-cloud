package com.itmei.observer;

/**
 * Created by qiaodan on 2017/9/14.
 */
public class Register extends Observer {
    @Override
    public void informAboutEvent(){

        System.out.println("Adding the action to register");
        super.informAboutEvent();
    }
}
