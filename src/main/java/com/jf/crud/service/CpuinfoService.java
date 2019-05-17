package com.jf.crud.service;

import com.jf.crud.bean.Cpuinfo;
import com.jf.crud.dao.CpuinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpuinfoService {
    @Autowired
    CpuinfoMapper cpuinfoMapper;
    public List<Cpuinfo> getAll() {
        return cpuinfoMapper.selectByExample(null);
    }
    public Cpuinfo getByCpuId(Integer cpuid) {
        Cpuinfo cpuinfo = cpuinfoMapper.selectByPrimaryKey(cpuid);
        return cpuinfo;
    }
}
