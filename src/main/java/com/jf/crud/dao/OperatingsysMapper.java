package com.jf.crud.dao;

import com.jf.crud.bean.Operatingsys;
import com.jf.crud.bean.OperatingsysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperatingsysMapper {
    long countByExample(OperatingsysExample example);

    int deleteByExample(OperatingsysExample example);

    int deleteByPrimaryKey(Integer osid);

    int insert(Operatingsys record);

    int insertSelective(Operatingsys record);

    List<Operatingsys> selectByExample(OperatingsysExample example);

    Operatingsys selectByPrimaryKey(Integer osid);

    int updateByExampleSelective(@Param("record") Operatingsys record, @Param("example") OperatingsysExample example);

    int updateByExample(@Param("record") Operatingsys record, @Param("example") OperatingsysExample example);

    int updateByPrimaryKeySelective(Operatingsys record);

    int updateByPrimaryKey(Operatingsys record);
}