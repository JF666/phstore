package com.jf.crud.service;

import com.jf.crud.bean.Frontcamera;
import com.jf.crud.dao.FrontcameraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrontcameraService {
    @Autowired
    FrontcameraMapper frontcameraMapper;
    public List<Frontcamera> getAll() {
        return frontcameraMapper.selectByExample(null);
    }
    public Frontcamera getByFcId(Integer fcid) {
        Frontcamera frontcamera = frontcameraMapper.selectByPrimaryKey(fcid);
        return frontcamera;
    }
}
