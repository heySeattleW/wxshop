package com.bjdvt.platform.model;

import com.bjdvt.platform.model.StyleBorderBottom;
import com.bjdvt.platform.model.StyleBorderBottomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StyleBorderBottomMapper {
    int countByExample(StyleBorderBottomExample example);

    int deleteByExample(StyleBorderBottomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StyleBorderBottom record);

    int insertSelective(StyleBorderBottom record);

    List<StyleBorderBottom> selectByExample(StyleBorderBottomExample example);

    StyleBorderBottom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StyleBorderBottom record, @Param("example") StyleBorderBottomExample example);

    int updateByExample(@Param("record") StyleBorderBottom record, @Param("example") StyleBorderBottomExample example);

    int updateByPrimaryKeySelective(StyleBorderBottom record);

    int updateByPrimaryKey(StyleBorderBottom record);
}