package com.jf.crud.service;

import com.jf.crud.bean.BuyerExample;
import com.jf.crud.bean.Buyer;
import com.jf.crud.dao.BuyerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {
    @Autowired
    BuyerMapper buyerMapper;
    public List<Buyer> getAll() {
        return buyerMapper.selectByExample(null);
    }
    public void insertBuyer(Buyer buyer) {
        buyerMapper.insertSelective(buyer);
    }
    public Buyer getByUserId(Integer userid) {
        Buyer buyer = buyerMapper.selectByUserId(userid);
        return buyer;
    }
    public Buyer getByBuyerId(Integer buyerid) {
        Buyer buyer = buyerMapper.selectByPrimaryKey(buyerid);
        return buyer;
    }
    public void UpdateBuyer(Buyer buyer) {
        buyerMapper.updateByPrimaryKeySelective(buyer);
    }
    public void DeleteBuyer(Integer userid) {
        buyerMapper.deleteByPrimaryKey(userid);
    }
    public void DeleteBatch(List<Integer> userids) {
        BuyerExample buyerExample = new BuyerExample();
        BuyerExample.Criteria criteria = buyerExample.createCriteria();
        criteria.andBuyeridIn(userids);
        buyerMapper.deleteByExample(buyerExample);
    }
}
