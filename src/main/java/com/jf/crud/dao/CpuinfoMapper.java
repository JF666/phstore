package com.jf.crud.dao;

import com.jf.crud.bean.Cpuinfo;
import com.jf.crud.bean.CpuinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpuinfoMapper {
    long countByExample(CpuinfoExample example);

    int deleteByExample(CpuinfoExample example);

    int deleteByPrimaryKey(Integer cpuid);

    int insert(Cpuinfo record);

    int insertSelective(Cpuinfo record);

    List<Cpuinfo> selectByExample(CpuinfoExample example);

    Cpuinfo selectByPrimaryKey(Integer cpuid);

    int updateByExampleSelective(@Param("record") Cpuinfo record, @Param("example") CpuinfoExample example);

    int updateByExample(@Param("record") Cpuinfo record, @Param("example") CpuinfoExample example);

    int updateByPrimaryKeySelective(Cpuinfo record);

    int updateByPrimaryKey(Cpuinfo record);
}