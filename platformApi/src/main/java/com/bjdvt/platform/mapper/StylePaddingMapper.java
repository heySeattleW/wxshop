package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.StylePadding;
import com.bjdvt.platform.model.StylePaddingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StylePaddingMapper {
    int countByExample(StylePaddingExample example);

    int deleteByExample(StylePaddingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StylePadding record);

    int insertSelective(StylePadding record);

    List<StylePadding> selectByExample(StylePaddingExample example);

    StylePadding selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StylePadding record, @Param("example") StylePaddingExample example);

    int updateByExample(@Param("record") StylePadding record, @Param("example") StylePaddingExample example);

    int updateByPrimaryKeySelective(StylePadding record);

    int updateByPrimaryKey(StylePadding record);
}