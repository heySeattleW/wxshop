package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.PageGroup;
import com.bjdvt.platform.model.PageGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageGroupMapper {
    int countByExample(PageGroupExample example);

    int deleteByExample(PageGroupExample example);

    int deleteByPrimaryKey(String id);

    int insert(PageGroup record);

    int insertSelective(PageGroup record);

    List<PageGroup> selectByExample(PageGroupExample example);

    PageGroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PageGroup record, @Param("example") PageGroupExample example);

    int updateByExample(@Param("record") PageGroup record, @Param("example") PageGroupExample example);

    int updateByPrimaryKeySelective(PageGroup record);

    int updateByPrimaryKey(PageGroup record);
}