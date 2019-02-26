package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.StylePhoto;
import com.bjdvt.platform.model.StylePhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StylePhotoMapper {
    int countByExample(StylePhotoExample example);

    int deleteByExample(StylePhotoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StylePhoto record);

    int insertSelective(StylePhoto record);

    List<StylePhoto> selectByExample(StylePhotoExample example);

    StylePhoto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StylePhoto record, @Param("example") StylePhotoExample example);

    int updateByExample(@Param("record") StylePhoto record, @Param("example") StylePhotoExample example);

    int updateByPrimaryKeySelective(StylePhoto record);

    int updateByPrimaryKey(StylePhoto record);
}