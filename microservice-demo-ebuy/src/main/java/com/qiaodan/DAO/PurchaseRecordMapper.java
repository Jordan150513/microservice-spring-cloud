package com.qiaodan.DAO;

import com.qiaodan.model.PurchaseRecord;
import com.qiaodan.model.PurchaseRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseRecordMapper {
    long countByExample(PurchaseRecordExample example);

    int deleteByExample(PurchaseRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseRecord record);

    int insertSelective(PurchaseRecord record);

    List<PurchaseRecord> selectByExample(PurchaseRecordExample example);

    PurchaseRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PurchaseRecord record, @Param("example") PurchaseRecordExample example);

    int updateByExample(@Param("record") PurchaseRecord record, @Param("example") PurchaseRecordExample example);

    int updateByPrimaryKeySelective(PurchaseRecord record);

    int updateByPrimaryKey(PurchaseRecord record);
}