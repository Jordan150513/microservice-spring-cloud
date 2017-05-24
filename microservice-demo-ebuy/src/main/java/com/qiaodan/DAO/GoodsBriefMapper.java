package com.qiaodan.DAO;

import com.qiaodan.model.GoodsBrief;
import com.qiaodan.model.GoodsBriefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsBriefMapper {
    long countByExample(GoodsBriefExample example);

    int deleteByExample(GoodsBriefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsBrief record);

    int insertSelective(GoodsBrief record);

    List<GoodsBrief> selectByExample(GoodsBriefExample example);

    GoodsBrief selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsBrief record, @Param("example") GoodsBriefExample example);

    int updateByExample(@Param("record") GoodsBrief record, @Param("example") GoodsBriefExample example);

    int updateByPrimaryKeySelective(GoodsBrief record);

    int updateByPrimaryKey(GoodsBrief record);
}