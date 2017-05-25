package com.qiaodan.controller;

import com.qiaodan.inmodel.LoginInModel;
import com.qiaodan.outmodel.BaseOutModel;
import com.qiaodan.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2017/5/9.
 */
@Api(value = "注册-控制器",description = "注册相关")
@ComponentScan("com.qiaodan.DAO")
@RestController
@RequestMapping(value = "/RegisterControlller/",method = RequestMethod.POST)
public class RegisterControlller {

    @Autowired
   private RegisterService registerService;
// http://localhost:9090/RegisterControlller/doRegister?name=baozi&password=baozi123&truename=baobao&sex=1&address=hunanchangsha&phoneno=18995627706&email=baobao@qq.com
@ApiOperation(value = "注册",notes = "操作行为")
@RequestMapping("doRegister")
    public BaseOutModel register(@RequestBody LoginInModel model){
        return registerService.register(model);
    }
}
