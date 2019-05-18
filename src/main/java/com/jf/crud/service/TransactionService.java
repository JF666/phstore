package com.jf.crud.service;

import com.jf.crud.bean.Transaction;
import com.jf.crud.dao.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    TransactionMapper transactionMapper;
    public List<Transaction> getAll() {
        return transactionMapper.selectByExample(null);
    }
    public List<Transaction> getByBuyerId(String createTime) {
        List<Transaction> transactions = transactionMapper.selectByPrimaryKeyWithProSeller(createTime);
        return transactions;
    }
    public List<Transaction> getByBuyer(Integer buyerid) {
        List<Transaction> transactions = transactionMapper.selectByPrimaryKey(buyerid);
        return transactions;
    }
    public List<Transaction> getBySeller(Integer sellerid) {
        List<Transaction> transactions = transactionMapper.selectBySeller(sellerid);
        return transactions;
    }
    public Boolean insertTransaction(Transaction transaction) {
        return transactionMapper.insertSelective(transaction)!=0;
    }
    public Boolean UpdateTransaction(Map<String, Object> params) {
        return transactionMapper.updateByPrimaryKeySelective(params)!=0;
    }
    public void DeleteTransaction(Integer tranid) {
        transactionMapper.deleteByPrimaryKey(tranid);
    }
}