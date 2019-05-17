package com.jf.crud.dao;

import com.jf.crud.bean.Size;
import com.jf.crud.bean.SizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SizeMapper {
    long countByExample(SizeExample example);

    int deleteByExample(SizeExample example);

    int deleteByPrimaryKey(Integer sizeid);

    int insert(Size record);

    int insertSelective(Size record);

    List<Size> selectByExample(SizeExample example);

    Size selectByPrimaryKey(Integer sizeid);

    int updateByExampleSelective(@Param("record") Size record, @Param("example") SizeExample example);

    int updateByExample(@Param("record") Size record, @Param("example") SizeExample example);

    int updateByPrimaryKeySelective(Size record);

    int updateByPrimaryKey(Size record);
}