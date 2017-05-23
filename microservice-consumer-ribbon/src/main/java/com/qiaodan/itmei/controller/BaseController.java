package com.qiaodan.itmei.controller;

import com.qiaodan.itmei.model.AddGoodsInModel;
import com.qiaodan.itmei.model.SubInfo;
import com.qiaodan.itmei.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by qiaodan on 2017/5/22.
 */
@RestController
public class BaseController {
    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "showBaseInfo",method = RequestMethod.POST )
    public String showBaseInfo(@RequestBody AddGoodsInModel model){
       String name =  model.getGoodName();
       List<SubInfo> list = model.getGoodInfoList();
       return name+" "+list.size();
//        return baseService.showBaseInfo();
    }
    // 参数传数组的问题 解决了
}
