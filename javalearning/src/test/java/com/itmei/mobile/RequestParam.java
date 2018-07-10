package com.itmei.mobile;

public class RequestParam {
    private String key = "";
    private String mobile="";
    private String code = "";
    private String message = "";
    private String data = "";
    private String seqNo = "";

    public RequestParam(String key, String mobile, String code, String message, String data, String seqNo) {
        this.key = key;
        this.mobile = mobile;
        this.code = code;
        this.message = message;
        this.data = data;
        this.seqNo = seqNo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }
}
