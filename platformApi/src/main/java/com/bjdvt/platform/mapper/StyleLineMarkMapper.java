package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.StyleLineMark;
import com.bjdvt.platform.model.StyleLineMarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StyleLineMarkMapper {
    int countByExample(StyleLineMarkExample example);

    int deleteByExample(StyleLineMarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StyleLineMark record);

    int insertSelective(StyleLineMark record);

    List<StyleLineMark> selectByExample(StyleLineMarkExample example);

    StyleLineMark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StyleLineMark record, @Param("example") StyleLineMarkExample example);

    int updateByExample(@Param("record") StyleLineMark record, @Param("example") StyleLineMarkExample example);

    int updateByPrimaryKeySelective(StyleLineMark record);

    int updateByPrimaryKey(StyleLineMark record);
}