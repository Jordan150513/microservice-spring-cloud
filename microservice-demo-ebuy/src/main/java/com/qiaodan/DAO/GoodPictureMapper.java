package com.qiaodan.DAO;

import com.qiaodan.model.GoodPicture;
import com.qiaodan.model.GoodPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodPictureMapper {
    long countByExample(GoodPictureExample example);

    int deleteByExample(GoodPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodPicture record);

    int insertSelective(GoodPicture record);

    List<GoodPicture> selectByExample(GoodPictureExample example);

    GoodPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodPicture record, @Param("example") GoodPictureExample example);

    int updateByExample(@Param("record") GoodPicture record, @Param("example") GoodPictureExample example);

    int updateByPrimaryKeySelective(GoodPicture record);

    int updateByPrimaryKey(GoodPicture record);
}