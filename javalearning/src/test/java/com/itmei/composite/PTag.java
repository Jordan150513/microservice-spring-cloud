package com.itmei.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiaodan on 2017/8/31.
 */
public class PTag implements TextTagComposite {

    private List<TextTag> tags = new ArrayList<TextTag>();

    @Override

    public void startWrite() {

        System.out.println("<p>");

    }

    @Override

    public void endWrite() {

        System.out.println("</p>");

    }

    @Override

    public List<TextTag> getTags() {

        return tags;

    }

    @Override

    public void addTag(TextTag tag) {

        tags.add(tag);

    }
}
