package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.StyleBox;
import com.bjdvt.platform.model.StyleBoxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StyleBoxMapper {
    int countByExample(StyleBoxExample example);

    int deleteByExample(StyleBoxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StyleBox record);

    int insertSelective(StyleBox record);

    List<StyleBox> selectByExample(StyleBoxExample example);

    StyleBox selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StyleBox record, @Param("example") StyleBoxExample example);

    int updateByExample(@Param("record") StyleBox record, @Param("example") StyleBoxExample example);

    int updateByPrimaryKeySelective(StyleBox record);

    int updateByPrimaryKey(StyleBox record);
}