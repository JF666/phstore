package com.jf.crud.dao;

import com.jf.crud.bean.Transaction;
import com.jf.crud.bean.TransactionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TransactionMapper {
    long countByExample(TransactionExample example);

    int deleteByExample(TransactionExample example);

    int deleteByPrimaryKey(Integer tranid);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    List<Transaction> selectByExample(TransactionExample example);

    List<Transaction> selectByPrimaryKeyWithProSeller(String createTime);

    List<Transaction> selectByPrimaryKey(Integer buyerid);

    int updateByExampleSelective(@Param("record") Transaction record, @Param("example") TransactionExample example);

    int updateByExample(@Param("record") Transaction record, @Param("example") TransactionExample example);

    int updateByPrimaryKeySelective(Map<String, Object> params);

    int updateByPrimaryKey(Transaction record);
}