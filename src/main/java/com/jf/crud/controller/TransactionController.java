package com.jf.crud.controller;

import com.jf.crud.bean.Transaction;
import com.jf.crud.service.TransactionService;
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
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    /**
     * 获取所有transaction表信息
     */
    @RequestMapping(value = "/transactions")
    @ResponseBody
    public Msg getTransactionsWithJson() {
        List<Transaction> transactions = transactionService.getAll();
        return Msg.success().add("transactions", transactions);
    }
    /**
     * 新增一条transaction记录
     */
    @RequestMapping(value = "/transactionInsert",method = RequestMethod.POST)
    @ResponseBody
    public Msg insertTransaction(Transaction transaction) {
        if (transactionService.insertTransaction(transaction)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    /**
     * 根据createTime查询
     */
    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByBuyerId(String createTime) {
        List<Transaction> transactions = transactionService.getByBuyerId(createTime);
        return Msg.success().add("transactions", transactions);
    }
    /**
     * 根据buyerId查询
     */
    @RequestMapping(value = "/tranByBuyer", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByBuyer(Integer buyerid) {
        List<Transaction> transactions = transactionService.getByBuyer(buyerid);
        return Msg.success().add("transactions", transactions);
    }
    /**
     * 根据sellerId查询
     */
    @RequestMapping(value = "/tranBySeller", method = RequestMethod.GET)
    @ResponseBody
    public Msg getBySeller(Integer sellerid) {
        List<Transaction> transactions = transactionService.getBySeller(sellerid);
        return Msg.success().add("transactions", transactions);
    }
    /**
     * 根据tranId修改更新
     */
    @RequestMapping(value = "/tranSts", method = RequestMethod.PUT)
    @ResponseBody
    public Msg UpdateTransaction(Integer transts,Integer tranid) {
        Map<String, Object> params = new HashMap<>();
        params.put("transts", transts);
        params.put("tranid", tranid);
        transactionService.UpdateTransaction(params);
        return Msg.success();
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/transaction/{tranid}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg DeleteTransaction(@PathVariable("tranid")String tranid) {
        transactionService.DeleteTransaction(Integer.parseInt(tranid));
        return Msg.success();
    }
}