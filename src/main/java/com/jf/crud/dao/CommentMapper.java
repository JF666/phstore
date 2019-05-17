package com.jf.crud.dao;

import com.jf.crud.bean.Comment;
import com.jf.crud.bean.CommentExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer commid);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer commid);

    Comment selectByBuyerId(Map<String, Object> params);

    Comment selectBySellerId(Map<String, Object> params);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}