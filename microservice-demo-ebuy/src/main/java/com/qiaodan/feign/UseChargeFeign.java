package com.qiaodan.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by qiaodan on 2017/5/18.
 */

@FeignClient(name = "microservice-account-wallet")
public interface UseChargeFeign {
    //
    @RequestMapping(value = "/wallet/ChargeController/chargeForUser",method = RequestMethod.GET)
    public String chargeForUser();
}
