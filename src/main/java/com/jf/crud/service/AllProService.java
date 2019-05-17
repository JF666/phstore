package com.jf.crud.service;

import com.jf.crud.bean.Allpro;
import com.jf.crud.dao.AllproMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllProService {
    @Autowired
    AllproMapper allproMapper;
    public List<Allpro> getAll() {
        List<Allpro> allpros = allproMapper.selectByExample(null);
        return allpros;
    }
    public List<Allpro> fuzzyQuery(String key) {
        List<Allpro> products = allproMapper.fuzzyQuery(key);
        return products;
    }
}