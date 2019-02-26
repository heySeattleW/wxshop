package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.StyleBorder;
import com.bjdvt.platform.model.StyleBorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StyleBorderMapper {
    int countByExample(StyleBorderExample example);

    int deleteByExample(StyleBorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StyleBorder record);

    int insertSelective(StyleBorder record);

    List<StyleBorder> selectByExample(StyleBorderExample example);

    StyleBorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StyleBorder record, @Param("example") StyleBorderExample example);

    int updateByExample(@Param("record") StyleBorder record, @Param("example") StyleBorderExample example);

    int updateByPrimaryKeySelective(StyleBorder record);

    int updateByPrimaryKey(StyleBorder record);
}