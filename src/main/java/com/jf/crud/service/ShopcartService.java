package com.jf.crud.service;

import com.jf.crud.bean.Shopcart;
import com.jf.crud.bean.ShopcartExample;
import com.jf.crud.dao.ShopcartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopcartService {
    @Autowired
    ShopcartMapper shopcartMapper;
    public List<Shopcart> getAll() {
        List<Shopcart> shopcart = shopcartMapper.selectByExample(null);
        return shopcart;
    }
    public List<Shopcart> getByBuyerId(Integer buyerid) {
        List<Shopcart> shopcart = shopcartMapper.selectByPrimaryKeyWithPro(buyerid);
        return shopcart;
    }
    public Integer proCount(Map<String, Object> params) {
        Integer proNum = shopcartMapper.countByProId(params);
        return proNum;
    }
    public boolean insertShopcart(Shopcart shopcart) {
        return shopcartMapper.insertSelective(shopcart)!=0;
    }
    public void UpdateShopcart(Shopcart shopcart) {
        shopcartMapper.updateByPrimaryKeySelective(shopcart);
    }
    public Boolean updateAmount(Map<String, Object> params) {
        return shopcartMapper.updateAmount(params)!=0;
    }
    public void DeleteShopcart(Integer shopcartid) {
        shopcartMapper.deleteByPrimaryKey(shopcartid);
    }
    public void DeleteBatch(List<Integer> shopcartids) {
        ShopcartExample shopcartExample = new ShopcartExample();
        ShopcartExample.Criteria criteria = shopcartExample.createCriteria();
        criteria.andShopcartidIn(shopcartids);
        shopcartMapper.deleteByExample(shopcartExample);
    }
}