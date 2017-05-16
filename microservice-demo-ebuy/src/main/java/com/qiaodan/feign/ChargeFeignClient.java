package com.qiaodan.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by qiaodan on 2017/5/16.
 */
@FeignClient(value = "MICROSERVICE-ACCOUNT-WALLET" )
public interface ChargeFeignClient {

    @RequestMapping(value = "/ChargeController/chargeForUser",method = RequestMethod.GET)
    public String chargeForUser();
}
