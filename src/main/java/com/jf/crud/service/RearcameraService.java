package com.jf.crud.service;

import com.jf.crud.bean.Rearcamera;
import com.jf.crud.dao.RearcameraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RearcameraService {
    @Autowired
    RearcameraMapper rearcameraMapper;
    public List<Rearcamera> getAll() {
        return rearcameraMapper.selectByExample(null);
    }
    public Rearcamera getByRcId(Integer rcid) {
        Rearcamera rearcamera = rearcameraMapper.selectByPrimaryKey(rcid);
        return rearcamera;
    }
}
