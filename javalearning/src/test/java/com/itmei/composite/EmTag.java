package com.itmei.composite;

/**
 * Created by qiaodan on 2017/8/31.
 */
public class EmTag implements TextTag {
    @Override

    public void startWrite() {

        System.out.println("<em>");

    }

    @Override

    public void endWrite() {

        System.out.println("</em>");

    }
}
