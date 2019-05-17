package com.jf.crud.dao;

import com.jf.crud.bean.Rearcamera;
import com.jf.crud.bean.RearcameraExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RearcameraMapper {
    long countByExample(RearcameraExample example);

    int deleteByExample(RearcameraExample example);

    int deleteByPrimaryKey(Integer rcid);

    int insert(Rearcamera record);

    int insertSelective(Rearcamera record);

    List<Rearcamera> selectByExample(RearcameraExample example);

    Rearcamera selectByPrimaryKey(Integer rcid);

    int updateByExampleSelective(@Param("record") Rearcamera record, @Param("example") RearcameraExample example);

    int updateByExample(@Param("record") Rearcamera record, @Param("example") RearcameraExample example);

    int updateByPrimaryKeySelective(Rearcamera record);

    int updateByPrimaryKey(Rearcamera record);
}