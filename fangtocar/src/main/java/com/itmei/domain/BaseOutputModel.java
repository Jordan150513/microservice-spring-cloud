package com.itmei.domain;

import java.io.Serializable;

/**
 * Created by qiaodan on 2018/5/14.
 */
public class BaseOutputModel implements Serializable {
    public int result;
    private String message;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
