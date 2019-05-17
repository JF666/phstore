package com.jf.crud.service;

import com.jf.crud.bean.Screen;
import com.jf.crud.dao.ScreenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService {
    @Autowired
    ScreenMapper screenMapper;
    public List<Screen> getAll() {
        return screenMapper.selectByExample(null);
    }
    public Screen getByScreenId(Integer screenid) {
        Screen screen = screenMapper.selectByPrimaryKey(screenid);
        return screen;
    }
}
