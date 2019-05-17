package com.jf.crud.dao;

import com.jf.crud.bean.Ramrom;
import com.jf.crud.bean.RamromExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RamromMapper {
    long countByExample(RamromExample example);

    int deleteByExample(RamromExample example);

    int deleteByPrimaryKey(Integer rmid);

    int insert(Ramrom record);

    int insertSelective(Ramrom record);

    List<Ramrom> selectByExample(RamromExample example);

    Ramrom selectByPrimaryKey(Integer rmid);

    int updateByExampleSelective(@Param("record") Ramrom record, @Param("example") RamromExample example);

    int updateByExample(@Param("record") Ramrom record, @Param("example") RamromExample example);

    int updateByPrimaryKeySelective(Ramrom record);

    int updateByPrimaryKey(Ramrom record);
}