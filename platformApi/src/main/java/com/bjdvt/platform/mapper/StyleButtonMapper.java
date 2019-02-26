package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.StyleButton;
import com.bjdvt.platform.model.StyleButtonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StyleButtonMapper {
    int countByExample(StyleButtonExample example);

    int deleteByExample(StyleButtonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StyleButton record);

    int insertSelective(StyleButton record);

    List<StyleButton> selectByExample(StyleButtonExample example);

    StyleButton selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StyleButton record, @Param("example") StyleButtonExample example);

    int updateByExample(@Param("record") StyleButton record, @Param("example") StyleButtonExample example);

    int updateByPrimaryKeySelective(StyleButton record);

    int updateByPrimaryKey(StyleButton record);
}