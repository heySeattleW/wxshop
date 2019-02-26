package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.WxImage;
import com.bjdvt.platform.model.WxImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxImageMapper {
    int countByExample(WxImageExample example);

    int deleteByExample(WxImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxImage record);

    int insertSelective(WxImage record);

    List<WxImage> selectByExample(WxImageExample example);

    WxImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxImage record, @Param("example") WxImageExample example);

    int updateByExample(@Param("record") WxImage record, @Param("example") WxImageExample example);

    int updateByPrimaryKeySelective(WxImage record);

    int updateByPrimaryKey(WxImage record);
}