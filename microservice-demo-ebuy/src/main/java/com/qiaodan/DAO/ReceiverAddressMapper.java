package com.qiaodan.DAO;

import com.qiaodan.model.ReceiverAddress;
import com.qiaodan.model.ReceiverAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiverAddressMapper {
    long countByExample(ReceiverAddressExample example);

    int deleteByExample(ReceiverAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReceiverAddress record);

    int insertSelective(ReceiverAddress record);

    List<ReceiverAddress> selectByExample(ReceiverAddressExample example);

    ReceiverAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReceiverAddress record, @Param("example") ReceiverAddressExample example);

    int updateByExample(@Param("record") ReceiverAddress record, @Param("example") ReceiverAddressExample example);

    int updateByPrimaryKeySelective(ReceiverAddress record);

    int updateByPrimaryKey(ReceiverAddress record);
}