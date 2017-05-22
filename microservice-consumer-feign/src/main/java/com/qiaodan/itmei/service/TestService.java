package com.qiaodan.itmei.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qiaodan.itmei.feign.UseChargeFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qiaodan on 2017/5/18.
 */
@Service
public class TestService {

    @Autowired
    private UseChargeFeign useChargeFeign;
    @HystrixCommand(defaultFallback = "testFallback")
    public String test(){
        return useChargeFeign.chargeForUser();
    }
    public String testFallback(){
        return "调用feign失败的fallback";
    }
}
