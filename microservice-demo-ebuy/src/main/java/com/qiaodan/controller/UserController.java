package com.qiaodan.controller;

import com.qiaodan.outmodel.UserInfoOutModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2017/5/25.
 */
@RestController
@RequestMapping("User")
@Api(value = "用户-控制器",description = "用户基本详细信息，用户购买记录，用户购物车。。。")
public class UserController {

    public UserInfoOutModel getUserInfo(){
        UserInfoOutModel userInfoOutModel = new UserInfoOutModel();


        return userInfoOutModel;
    }
}
