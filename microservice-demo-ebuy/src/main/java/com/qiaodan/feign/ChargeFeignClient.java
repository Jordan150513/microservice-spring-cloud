package com.qiaodan.feign;

import com.configure.FooConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by qiaodan on 2017/5/16.
 */
@Component
@FeignClient(value = "microservice-account-wallet",configuration = FooConfiguration.class)
public interface ChargeFeignClient {

//    @RequestMapping(value = "/wallet/ChargeController/chargeForUser",method = RequestMethod.GET)
//    public String chargeForUser();
}
