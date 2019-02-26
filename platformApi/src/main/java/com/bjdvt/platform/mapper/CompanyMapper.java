package com.bjdvt.platform.mapper;

import com.bjdvt.platform.model.Company;
import com.bjdvt.platform.model.CompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyMapper {
    int countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExample(CompanyExample example);

    Company selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}