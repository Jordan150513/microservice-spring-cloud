package com.qiaodan.service;

import com.qiaodan.feign.ChargeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qiaodan on 2017/5/18.
 */
@Service
public class TestService {
    @Autowired
    private ChargeFeignClient chargeFeignClient;

    public  String useFeign(){
        return chargeFeignClient.chargeForUser();
    }
}
