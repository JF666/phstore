package com.jf.crud.service;

import com.jf.crud.bean.Comment;
import com.jf.crud.bean.CommentExample;
import com.jf.crud.dao.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    public List<Comment> getAll() {
        return commentMapper.selectByExample(null);
    }
    public Boolean insertComment(Comment comment) {
        return commentMapper.insertSelective(comment)!=0;
    }
    public List<Comment> getByProId(Integer proid) {
        List<Comment> comment = commentMapper.selectByPrimaryKeyProId(proid);
        return comment;
    }
    public List<Comment> getByBuyerId(Integer buyerid) {
        List<Comment> comment = commentMapper.selectByBuyerId(buyerid);
        return comment;
    }
    public void UpdateComment(Comment comment) {
        commentMapper.updateByPrimaryKeySelective(comment);
    }
    public void DeleteComment(Integer commid) {
        commentMapper.deleteByPrimaryKey(commid);
    }
}
