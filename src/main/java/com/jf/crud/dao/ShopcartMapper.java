package com.jf.crud.dao;

import com.jf.crud.bean.Shopcart;
import com.jf.crud.bean.ShopcartExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ShopcartMapper {
    long countByExample(ShopcartExample example);

    int deleteByExample(ShopcartExample example);

    int deleteByPrimaryKey(Integer shopcartid);

    int insert(Shopcart record);

    int insertSelective(Shopcart record);

    List<Shopcart> selectByExample(ShopcartExample example);

    List<Shopcart> selectByPrimaryKeyWithPro(Integer buyerid);

    Integer countByProId(Map<String, Object> params);

    Shopcart selectByPrimaryKey(Integer shopcartid);

    int updateByExampleSelective(@Param("record") Shopcart record, @Param("example") ShopcartExample example);

    int updateByExample(@Param("record") Shopcart record, @Param("example") ShopcartExample example);

    int updateByPrimaryKeySelective(Shopcart record);

    int updateAmount(Map<String, Object> params);

    int updateByPrimaryKey(Shopcart record);
}