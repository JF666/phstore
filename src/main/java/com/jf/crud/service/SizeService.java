package com.jf.crud.service;

import com.jf.crud.bean.Size;
import com.jf.crud.dao.SizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {
    @Autowired
    SizeMapper sizeMapper;
    public List<Size> getAll() {
        return sizeMapper.selectByExample(null);
    }
    public Size getBySizeId(Integer sizeid) {
        Size size = sizeMapper.selectByPrimaryKey(sizeid);
        return size;
    }
}
