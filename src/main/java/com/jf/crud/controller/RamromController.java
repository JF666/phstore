package com.jf.crud.controller;

import com.jf.crud.bean.Ramrom;
import com.jf.crud.service.RamromService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class RamromController {
    @Autowired
    RamromService ramromService;
    /**
     * 获取所有ramrom表信息
     */
    @RequestMapping(value = "/ramroms")
    @ResponseBody
    public Msg getRamromsWithJson() {
        List<Ramrom> ramroms = ramromService.getAll();
        return Msg.success().add("ramroms", ramroms);
    }
    /**
     * 根据cpuId查询
     */
    @RequestMapping(value = "/ramrom/{rmid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByRmId(@PathVariable("rmid")Integer rmid) {
        Ramrom ramrom = ramromService.getByRmId(rmid);
        return Msg.success().add("ramrom", ramrom);
    }
}
