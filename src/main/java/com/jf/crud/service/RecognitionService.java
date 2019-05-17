package com.jf.crud.service;

import com.jf.crud.bean.Recognition;
import com.jf.crud.dao.RecognitionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecognitionService {
    @Autowired
    RecognitionMapper recognitionMapper;
    public List<Recognition> getAll() {
        return recognitionMapper.selectByExample(null);
    }
    public Recognition getByRecId(Integer recid) {
        Recognition recognition = recognitionMapper.selectByPrimaryKey(recid);
        return recognition;
    }
}
