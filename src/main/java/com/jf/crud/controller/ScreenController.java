package com.jf.crud.controller;

import com.jf.crud.bean.Screen;
import com.jf.crud.service.ScreenService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class ScreenController {
    @Autowired
    ScreenService screenService;
    /**
     * 获取所有screen表信息
     */
    @RequestMapping(value = "/screens")
    @ResponseBody
    public Msg getScreensWithJson() {
        List<Screen> screens = screenService.getAll();
        return Msg.success().add("screens", screens);
    }
    /**
     * 根据cpuId查询
     */
    @RequestMapping(value = "/screen/{screenid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByScreenId(@PathVariable("screenid")Integer screenid) {
        Screen screen = screenService.getByScreenId(screenid);
        return Msg.success().add("screen", screen);
    }
}
