package com.jf.crud.controller;

import com.jf.crud.bean.Frontcamera;
import com.jf.crud.service.FrontcameraService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class FrontcameraController {
    @Autowired
    FrontcameraService frontcameraService;
    /**
     * 获取所有frontcamera表信息
     */
    @RequestMapping(value = "/frontcameras")
    @ResponseBody
    public Msg getFrontcamerasWithJson() {
        List<Frontcamera> frontcameras = frontcameraService.getAll();
        return Msg.success().add("frontcameras", frontcameras);
    }
    /**
     * 根据cpuId查询
     */
    @RequestMapping(value = "/frontcamera/{fcid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByFcId(@PathVariable("fcid")Integer fcid) {
        Frontcamera frontcamera = frontcameraService.getByFcId(fcid);
        return Msg.success().add("frontcamera", frontcamera);
    }
}
