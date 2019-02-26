package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.Data;
import com.bjdvt.platform.model.DataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataMapper {
    int countByExample(DataExample example);

    int deleteByExample(DataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Data record);

    int insertSelective(Data record);

    List<Data> selectByExample(DataExample example);

    Data selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Data record, @Param("example") DataExample example);

    int updateByExample(@Param("record") Data record, @Param("example") DataExample example);

    int updateByPrimaryKeySelective(Data record);

    int updateByPrimaryKey(Data record);
}