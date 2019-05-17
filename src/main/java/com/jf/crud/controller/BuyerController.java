package com.jf.crud.controller;

import com.jf.crud.bean.Buyer;
import com.jf.crud.service.BuyerService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class BuyerController {
    @Autowired
    BuyerService buyerService;
    /**
     * 获取所有buyer表信息
     */
    @RequestMapping(value = "/buyers")
    @ResponseBody
    public Msg getAll() {
        List<Buyer> buyers = buyerService.getAll();
        return Msg.success().add("buyers", buyers);
    }
    /**
     * 新增一条buyer记录
     */
    @RequestMapping(value = "/buyerInsert",method = RequestMethod.POST)
    @ResponseBody
    public Msg insertBuyer(@Valid Buyer buyer, BindingResult result) {
        if(result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误字段名："+fieldError.getField());
                System.out.println("错误信息："+fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        } else {
            buyerService.insertBuyer(buyer);
            return Msg.success();
        }
    }
    /**
     * 根据userid查询
     */
    @RequestMapping(value = "/buyerById/{userid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByUserId(@PathVariable("userid")Integer userid) {
        Buyer buyer = buyerService.getByUserId(userid);
        return Msg.success().add("buyer", buyer);
    }
    /**
     * 根据buyerid查询
     */
    @RequestMapping(value = "/buyer/{buyerid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByBuyerId(@PathVariable("buyerid")Integer buyerid) {
        Buyer buyer = buyerService.getByBuyerId(buyerid);
        return Msg.success().add("buyer", buyer);
    }
    /**
     * 根据userid修改更新
     */
    @RequestMapping(value = "/buyer/{userid}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg UpdateBuyer(Buyer buyer) {
        buyerService.UpdateBuyer(buyer);
        return Msg.success();
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/buyer/{userids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg DeleteBuyer(@PathVariable("userids")String userids) {
        if (userids.contains("/")) {
            List<Integer> del_userids = new ArrayList<>();
            String[] str_userids = userids.split("/");
            for (String string : str_userids) {
                del_userids.add(Integer.parseInt(string));
            }
            buyerService.DeleteBatch(del_userids);
        } else {
            buyerService.DeleteBuyer(Integer.parseInt(userids));
        }
        return Msg.success();
    }
}
