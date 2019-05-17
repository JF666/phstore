package com.jf.crud.controller;

import com.jf.crud.bean.Rearcamera;
import com.jf.crud.service.RearcameraService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class RearcameraController {
    @Autowired
    RearcameraService rearcameraService;
    /**
     * 获取所有rearcamera表信息
     */
    @RequestMapping(value = "/rearcameras")
    @ResponseBody
    public Msg getRearcamerasWithJson() {
        List<Rearcamera> rearcameras = rearcameraService.getAll();
        return Msg.success().add("rearcameras", rearcameras);
    }
    /**
     * 根据cpuId查询
     */
    @RequestMapping(value = "/rearcamera/{rcid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByRcId(@PathVariable("rcid")Integer rcid) {
        Rearcamera rearcamera = rearcameraService.getByRcId(rcid);
        return Msg.success().add("rearcamera", rearcamera);
    }
}
