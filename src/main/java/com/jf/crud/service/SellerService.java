package com.jf.crud.service;

import com.jf.crud.bean.Seller;
import com.jf.crud.bean.SellerExample;
import com.jf.crud.dao.SellerMapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    SellerMapper sellerMapper;
    public List<Seller> getAll() {
        List<Seller> sellers = sellerMapper.selectByExample(null);
        return sellers;
    }
    public Boolean insertSeller(Seller seller) {
        return sellerMapper.insertSelective(seller)!=0;
    }
    public Seller getBySellerId(Integer sellerid) {
        Seller seller = sellerMapper.selectByPrimaryKey(sellerid);
        return seller;
    }public Seller getByUserId(Integer userid) {
        Seller seller = sellerMapper.selectByUserId(userid);
        return seller;
    }
    public void UpdateSeller(Seller seller) {
        sellerMapper.updateByPrimaryKeySelective(seller);
    }
    public void DeleteSeller(Integer userid) {
        sellerMapper.deleteByPrimaryKey(userid);
    }
    public void DeleteBatch(List<Integer> userids) {
        SellerExample sellerExample = new SellerExample();
        SellerExample.Criteria criteria = sellerExample.createCriteria();
        criteria.andUseridIn(userids);
        sellerMapper.deleteByExample(sellerExample);
    }
}
