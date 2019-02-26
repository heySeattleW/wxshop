package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.Tabbar;
import com.bjdvt.platform.model.TabbarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabbarMapper {
    int countByExample(TabbarExample example);

    int deleteByExample(TabbarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tabbar record);

    int insertSelective(Tabbar record);

    List<Tabbar> selectByExample(TabbarExample example);

    Tabbar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tabbar record, @Param("example") TabbarExample example);

    int updateByExample(@Param("record") Tabbar record, @Param("example") TabbarExample example);

    int updateByPrimaryKeySelective(Tabbar record);

    int updateByPrimaryKey(Tabbar record);
    
}