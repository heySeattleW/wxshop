package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.StyleText;
import com.bjdvt.platform.model.StyleTextExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StyleTextMapper {
    int countByExample(StyleTextExample example);

    int deleteByExample(StyleTextExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StyleText record);

    int insertSelective(StyleText record);

    List<StyleText> selectByExample(StyleTextExample example);

    StyleText selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StyleText record, @Param("example") StyleTextExample example);

    int updateByExample(@Param("record") StyleText record, @Param("example") StyleTextExample example);

    int updateByPrimaryKeySelective(StyleText record);

    int updateByPrimaryKey(StyleText record);
}