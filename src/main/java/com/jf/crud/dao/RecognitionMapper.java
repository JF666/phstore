package com.jf.crud.dao;

import com.jf.crud.bean.Recognition;
import com.jf.crud.bean.RecognitionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecognitionMapper {
    long countByExample(RecognitionExample example);

    int deleteByExample(RecognitionExample example);

    int deleteByPrimaryKey(Integer recid);

    int insert(Recognition record);

    int insertSelective(Recognition record);

    List<Recognition> selectByExample(RecognitionExample example);

    Recognition selectByPrimaryKey(Integer recid);

    int updateByExampleSelective(@Param("record") Recognition record, @Param("example") RecognitionExample example);

    int updateByExample(@Param("record") Recognition record, @Param("example") RecognitionExample example);

    int updateByPrimaryKeySelective(Recognition record);

    int updateByPrimaryKey(Recognition record);
}