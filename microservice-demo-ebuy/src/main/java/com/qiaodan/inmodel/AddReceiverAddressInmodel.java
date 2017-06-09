package com.qiaodan.inmodel;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by qiaodan on 2017/6/9.
 */
public class AddReceiverAddressInmodel {

    @ApiModelProperty(value = "用户ID",required = true)
    private Integer userid;

    @ApiModelProperty(value = "收件人姓名",required = true)
    private String receivername;

    @ApiModelProperty(value = "收件人地址",required = true)
    private String receiveraddress;

    @ApiModelProperty(value = "收件人电话",required = true)
    private Long receiverphone;

    @ApiModelProperty(value = "是否是默认收件人")
    private Boolean isdefault;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername;
    }

    public String getReceiveraddress() {
        return receiveraddress;
    }

    public void setReceiveraddress(String receiveraddress) {
        this.receiveraddress = receiveraddress;
    }

    public Long getReceiverphone() {
        return receiverphone;
    }

    public void setReceiverphone(Long receiverphone) {
        this.receiverphone = receiverphone;
    }

    public Boolean getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }
}
