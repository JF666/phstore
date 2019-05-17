package com.jf.crud.dao;

import com.jf.crud.bean.Battery;
import com.jf.crud.bean.BatteryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatteryMapper {
    long countByExample(BatteryExample example);

    int deleteByExample(BatteryExample example);

    int deleteByPrimaryKey(Integer charbattid);

    int insert(Battery record);

    int insertSelective(Battery record);

    List<Battery> selectByExample(BatteryExample example);

    Battery selectByPrimaryKey(Integer charbattid);

    int updateByExampleSelective(@Param("record") Battery record, @Param("example") BatteryExample example);

    int updateByExample(@Param("record") Battery record, @Param("example") BatteryExample example);

    int updateByPrimaryKeySelective(Battery record);

    int updateByPrimaryKey(Battery record);
}