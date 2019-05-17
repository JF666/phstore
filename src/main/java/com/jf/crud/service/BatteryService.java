package com.jf.crud.service;

import com.jf.crud.bean.Battery;
import com.jf.crud.dao.BatteryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatteryService {
    @Autowired
    BatteryMapper batteryMapper;
    public List<Battery> getAll() {
        return batteryMapper.selectByExample(null);
    }
    public Battery getByCharBatId(Integer charbattid) {
        Battery battery = batteryMapper.selectByPrimaryKey(charbattid);
        return battery;
    }
}
