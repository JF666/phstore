package com.jf.crud.dao;

import com.jf.crud.bean.Buyer;
import com.jf.crud.bean.BuyerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuyerMapper {
    long countByExample(BuyerExample example);

    int deleteByExample(BuyerExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(Buyer record);

    int insertSelective(Buyer record);

    List<Buyer> selectByExample(BuyerExample example);

    Buyer selectByPrimaryKey(Integer buyerid);

    Buyer selectByUserId(Integer userid);

    int updateByExampleSelective(@Param("record") Buyer record, @Param("example") BuyerExample example);

    int updateByExample(@Param("record") Buyer record, @Param("example") BuyerExample example);

    int updateByPrimaryKeySelective(Buyer record);

    int updateByPrimaryKey(Buyer record);
}