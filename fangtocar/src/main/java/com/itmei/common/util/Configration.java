package com.itmei.common.util;

import org.springframework.stereotype.Component;

/**
 * Created by qiaodan on 2018/5/11.
 */
@Component
public interface Configration {
    /**
     * 是否測試
     */
    public static boolean DEBUG = false;
    /**
     * 错误成功
     */
    public static final Integer OK=0;
    /**
     * 全局异常失败
     */
    public static final Integer ERROR=-100;
}
