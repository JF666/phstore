package com.jf.crud.dao;

import com.jf.crud.bean.Frontcamera;
import com.jf.crud.bean.FrontcameraExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FrontcameraMapper {
    long countByExample(FrontcameraExample example);

    int deleteByExample(FrontcameraExample example);

    int deleteByPrimaryKey(Integer fcid);

    int insert(Frontcamera record);

    int insertSelective(Frontcamera record);

    List<Frontcamera> selectByExample(FrontcameraExample example);

    Frontcamera selectByPrimaryKey(Integer fcid);

    int updateByExampleSelective(@Param("record") Frontcamera record, @Param("example") FrontcameraExample example);

    int updateByExample(@Param("record") Frontcamera record, @Param("example") FrontcameraExample example);

    int updateByPrimaryKeySelective(Frontcamera record);

    int updateByPrimaryKey(Frontcamera record);
}