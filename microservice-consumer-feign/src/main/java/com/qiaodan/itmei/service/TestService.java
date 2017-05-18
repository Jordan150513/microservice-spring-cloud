package com.qiaodan.itmei.service;

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
    public String test(){
        return useChargeFeign.chargeForUser();
    }
}
