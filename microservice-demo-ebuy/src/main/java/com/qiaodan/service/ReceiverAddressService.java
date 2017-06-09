package com.qiaodan.service;

import com.qiaodan.DAO.ReceiverAddressMapper;
import com.qiaodan.inmodel.AddReceiverAddressInmodel;
import com.qiaodan.model.ReceiverAddress;
import com.qiaodan.model.ReceiverAddressExample;
import com.qiaodan.outmodel.BaseOutModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qiaodan on 2017/6/9.
 */
@Service
public class ReceiverAddressService {

    @Autowired
    private ReceiverAddressMapper receiverAddressMapper;

    public BaseOutModel AddReceiverAddress(AddReceiverAddressInmodel inmodel,BaseOutModel outModel){
        ReceiverAddress receiverAddress = new ReceiverAddress();
        int rs=0;
        if (inmodel.getIsdefault()==true){
            //设置了新的默认地址，要将之前的默认地址 改成非默认地址
            ReceiverAddressExample receiverAddressExample = new ReceiverAddressExample();
            receiverAddressExample.createCriteria().andUseridEqualTo(inmodel.getUserid()).andIsdefaultEqualTo(true);
            List<ReceiverAddress> list =  receiverAddressMapper.selectByExample(receiverAddressExample);
            // 将之前的改成非默认的 只会有一个
            if (list!=null) {
                for (int i = 0; i < list.size(); i++) {
                    ReceiverAddress item = list.get(i);
                    item.setIsdefault(false);
                    rs = receiverAddressMapper.updateByPrimaryKey(receiverAddress);
                    if (rs == 0) {
                        outModel.setCode(0);
                        outModel.setMessage("更新收货人地址失败！");
                        return outModel;
                    }
                }
            }
        }

        // 两个对象之间拷贝属性
        BeanUtils.copyProperties(inmodel,receiverAddress);
        rs = receiverAddressMapper.insertSelective(receiverAddress);

        if (rs==1){
            outModel.setCode(1);
            outModel.setMessage("添加成功");
        }
        outModel.setCode(0);
        outModel.setMessage("添加失败");
        return outModel;
    }
}
