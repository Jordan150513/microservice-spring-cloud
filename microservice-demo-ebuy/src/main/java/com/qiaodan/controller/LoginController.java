package com.qiaodan.controller;

import com.qiaodan.DAO.UserinfoMapper;
import com.qiaodan.inmodel.LoginInModel;
import com.qiaodan.model.Userinfo;
import com.qiaodan.model.UserinfoExample;
import com.qiaodan.outmodel.BaseOutModel;
import com.qiaodan.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by qiaodan on 2017/5/9.
 */
@Api(value = "登陆-控制器",description = "登陆")
@RestController
@RequestMapping("/LoginController/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //  http://localhost:9090/LoginController/login?name=baozi&password=baozi123
    @ApiOperation(value = "登陆操作",notes = "操作行为")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseOutModel login(@RequestParam String name,@RequestParam String password){
       return loginService.login(name,password);
    }
}
