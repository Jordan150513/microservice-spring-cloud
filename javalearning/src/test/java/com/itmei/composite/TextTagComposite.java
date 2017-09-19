package com.itmei.composite;

import java.util.List;

/**
 * Created by qiaodan on 2017/8/31.
 */
public interface TextTagComposite extends TextTag {
    public List<TextTag> getTags();
    public void addTag(TextTag tag);
}
