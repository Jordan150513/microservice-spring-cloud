package com.qiaodan.itmei.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by qiaodan on 2017/5/16.
 */
@RestController
@RequestMapping("/TestController/")

@Api(value = "wallet的TestController",description = "test controller")
public class TestController {
    @Autowired
    private EurekaClient discoveryClient;

    @RequestMapping(value = "getTestMessage",method = RequestMethod.GET)
    public String getTestMessage(String message){
        return "Hello "+message;
    }

    @ApiOperation(value = "getServiceUrl",notes = "获取某个指定服务的ip地址")
    @RequestMapping(value = "getServiceUrl",method = RequestMethod.GET)
    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("MICROSERVICE-ACCOUNT-WALLET", false);
        return instance.getHomePageUrl();
        // http://10.2.123.177:7979/
        // 可以成功返回信息
    }

// 上下两种方式怎么不兼容呢？
//    @Autowired
//    private DiscoveryClient discoveryClient;
//    @ApiOperation(value = "getServiceUrl2",notes = "获取某个指定服务的ip地址方式2")
//    @RequestMapping(value = "getServiceUrl2",method = RequestMethod.GET)
//    public String serviceUrl2() {
//        List<ServiceInstance> list = discoveryClient.getInstances("MICROSERVICE-ACCOUNT-WALLET");
//        if (list != null && list.size() > 0 ) {
//            return list.get(0).getUri().toString();
//        }
//        return null;
//    }

}
