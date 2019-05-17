package com.jf.crud.dao;

import com.jf.crud.bean.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TransactionMapperTest {
    @Autowired
    private TransactionMapper transactionMapper;

    @Test
    public void getByBuyerId() {
        List<Transaction> transactions = transactionMapper.selectByPrimaryKeyWithProSeller("1557592338351");
        System.out.println(transactions.size());
    }
}
