package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.Tabbaritem;
import com.bjdvt.platform.model.TabbaritemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabbaritemMapper {
    int countByExample(TabbaritemExample example);

    int deleteByExample(TabbaritemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tabbaritem record);

    int insertSelective(Tabbaritem record);

    List<Tabbaritem> selectByExample(TabbaritemExample example);

    Tabbaritem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tabbaritem record, @Param("example") TabbaritemExample example);

    int updateByExample(@Param("record") Tabbaritem record, @Param("example") TabbaritemExample example);

    int updateByPrimaryKeySelective(Tabbaritem record);

    int updateByPrimaryKey(Tabbaritem record);
}