package com.jf.crud.dao;

import com.jf.crud.bean.Buyer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BuyerMapperTest {
    @Autowired
    private BuyerMapper buyerMapper;

    @Test
    public void getByBuyerId() {
        Buyer buyer = new Buyer(1,11,"aaaaaa11","9999","南京工程学院","15199999999","马云");
        int a = buyerMapper.updateByPrimaryKeySelective(buyer);
        System.out.println(a);
    }
}
