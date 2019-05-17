package com.jf.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jf.crud.bean.Comment;
import com.jf.crud.service.CommentService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class CommentController {
    @Autowired
    CommentService commentService;
    /**
     * 获取所有comment表信息
     */
    @RequestMapping(value = "/comments")
    @ResponseBody
    public Msg getCommentsWithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn) {
        PageHelper.startPage(pn, 10);
        List<Comment> comments = commentService.getAll();
        PageInfo page = new PageInfo(comments, 5);
        return Msg.success().add("pageInfo", page);
    }
    /**
     * 新增一条comment记录
     */
    @RequestMapping(value = "/commentInsert",method = RequestMethod.POST)
    @ResponseBody
    public Msg insertComment(@Valid Comment comment) {
        if (commentService.insertComment(comment)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    /**
     * 根据proId查询
     */
    @RequestMapping(value = "/commentByBuyerId", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByBuyerId(Integer buyerid, Integer proid) {
        Map<String, Object> params = new HashMap<>();
        params.put("buyerid", buyerid);
        params.put("proid", proid);
        Comment comment = commentService.getByBuyerId(params);
        return Msg.success().add("comment", comment);
    }
    /**
     * 根据proId查询
     */
    @RequestMapping(value = "/commentBySellerId", method = RequestMethod.GET)
    @ResponseBody
    public Msg getBySellerId(Integer sellerid, Integer proid) {
        Map<String, Object> params = new HashMap<>();
        params.put("sellerid", sellerid);
        params.put("proid", proid);
        Comment comment = commentService.getBySellerId(params);
        return Msg.success().add("comment", comment);
    }
    /**
     * 根据commId修改更新
     */
    @RequestMapping(value = "/comment/{commid}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg UpdateComment(Comment comment) {
        commentService.UpdateComment(comment);
        return Msg.success();
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/comment/{commid}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg DeleteComment(@PathVariable("commid")String commid) {
        commentService.DeleteComment(Integer.parseInt(commid));
        return Msg.success();
    }
}
