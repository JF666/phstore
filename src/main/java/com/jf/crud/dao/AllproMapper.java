package com.jf.crud.dao;

import com.jf.crud.bean.Allpro;
import com.jf.crud.bean.AllproExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AllproMapper {
    long countByExample(AllproExample example);

    int deleteByExample(AllproExample example);

    int deleteByPrimaryKey(Integer allid);

    int insert(Allpro record);

    int insertSelective(Allpro record);

    List<Allpro> selectByExample(AllproExample example);

    List<Allpro> fuzzyQuery(String key);

    Allpro selectByPrimaryKey(Integer allid);

    int updateByExampleSelective(@Param("record") Allpro record, @Param("example") AllproExample example);

    int updateByExample(@Param("record") Allpro record, @Param("example") AllproExample example);

    int updateByPrimaryKeySelective(Allpro record);

    int updateByPrimaryKey(Allpro record);
}