package com.jf.crud.service;

import com.jf.crud.bean.Ramrom;
import com.jf.crud.dao.RamromMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RamromService {
    @Autowired
    RamromMapper ramromMapper;
    public List<Ramrom> getAll() {
        return ramromMapper.selectByExample(null);
    }
    public Ramrom getByRmId(Integer rmid) {
        Ramrom ramrom = ramromMapper.selectByPrimaryKey(rmid);
        return ramrom;
    }
}
