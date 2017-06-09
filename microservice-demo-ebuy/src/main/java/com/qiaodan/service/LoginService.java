package com.qiaodan.service;

import com.qiaodan.DAO.UserinfoMapper;
import com.qiaodan.inmodel.LoginInModel;
import com.qiaodan.model.Userinfo;
import com.qiaodan.model.UserinfoExample;
import com.qiaodan.outmodel.BaseOutModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qiaodan on 2017/5/11.
 */
@Service
public class LoginService {
    @Autowired
    private UserinfoMapper userinfoMapper;

    public BaseOutModel login(String name ,String password){
        BaseOutModel outModel = new BaseOutModel();
        if (name==null||name.length()==0){
            outModel.setCode(0);
            outModel.setMessage("用户名不能为空！");
            return outModel;
        }else if (password==null||password.length()==0){
            outModel.setMessage("密码不能为空");
            outModel.setCode(0);
            return outModel;
        }
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        criteria.andUsernameEqualTo(name);
        criteria.andPasswordEqualTo(password);
        List<Userinfo> list = userinfoMapper.selectByExample(userinfoExample);
        if (list==null){
            outModel.setCode(0);
            outModel.setMessage("登陆失败！");
            return outModel;
        }else if (list!=null&&list.size()==1){
            outModel.setCode(1);
            Userinfo userinfo = list.get(0);
            outModel.setMessage("登陆成功"+userinfo.toString());
            return outModel;
        }else {
            outModel.setCode(0);
            outModel.setMessage("登陆失败！");
            return outModel;
        }
    }
}
