package com.jf.crud.controller;

import com.jf.crud.bean.Battery;
import com.jf.crud.service.BatteryService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class BatteryController {
    @Autowired
    BatteryService batteryService;
    /**
     * 获取所有battery表信息
     */
    @RequestMapping(value = "/batterys")
    @ResponseBody
    public Msg getBatterysWithJson() {
        List<Battery> batterys = batteryService.getAll();
        return Msg.success().add("batterys", batterys);
    }
    /**
     * 根据cpuId查询
     */
    @RequestMapping(value = "/battery/{charbattid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByCharBatId(@PathVariable("charbattid")Integer charbattid) {
        Battery battery = batteryService.getByCharBatId(charbattid);
        return Msg.success().add("battery", battery);
    }
}
