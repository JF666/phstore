package com.jf.crud.service;

import com.jf.crud.bean.Operatingsys;
import com.jf.crud.dao.OperatingsysMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatingsysService {
    @Autowired
    OperatingsysMapper operatingsysMapper;
    public List<Operatingsys> getAll() {
        return operatingsysMapper.selectByExample(null);
    }
    public Operatingsys getByOsId(Integer osid) {
        Operatingsys operatingsys = operatingsysMapper.selectByPrimaryKey(osid);
        return operatingsys;
    }
}
