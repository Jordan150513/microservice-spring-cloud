package com.itmei.observer;

/**
 * Created by qiaodan on 2017/9/14.
 */
public class PageOpener extends Observer {
    @Override
    public void informAboutEvent(){

        System.out.println("Preparing download of new page");
        super.informAboutEvent();
    }
}
