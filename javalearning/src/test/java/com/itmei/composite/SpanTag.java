package com.itmei.composite;

/**
 * Created by qiaodan on 2017/8/31.
 */
public class SpanTag implements TextTag {

    @Override

    public void startWrite() {

        System.out.println("<span>");

    }

    @Override

    public void endWrite() {

        System.out.println("</span>");

    }
}
