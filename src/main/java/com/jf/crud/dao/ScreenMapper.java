package com.jf.crud.dao;

import com.jf.crud.bean.Screen;
import com.jf.crud.bean.ScreenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScreenMapper {
    long countByExample(ScreenExample example);

    int deleteByExample(ScreenExample example);

    int deleteByPrimaryKey(Integer screenid);

    int insert(Screen record);

    int insertSelective(Screen record);

    List<Screen> selectByExample(ScreenExample example);

    Screen selectByPrimaryKey(Integer screenid);

    int updateByExampleSelective(@Param("record") Screen record, @Param("example") ScreenExample example);

    int updateByExample(@Param("record") Screen record, @Param("example") ScreenExample example);

    int updateByPrimaryKeySelective(Screen record);

    int updateByPrimaryKey(Screen record);
}