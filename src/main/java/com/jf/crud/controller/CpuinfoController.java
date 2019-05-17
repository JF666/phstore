package com.jf.crud.controller;

import com.jf.crud.bean.Cpuinfo;
import com.jf.crud.service.CpuinfoService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class CpuinfoController {
    @Autowired
    CpuinfoService cpuinfoService;
    /**
     * 获取所有cpuinfo表信息
     */
    @RequestMapping(value = "/cpuinfos")
    @ResponseBody
    public Msg getCpuinfosWithJson() {
        List<Cpuinfo> cpuinfos = cpuinfoService.getAll();
        return Msg.success().add("cpuinfos", cpuinfos);
    }
    /**
     * 根据cpuId查询
     */
    @RequestMapping(value = "/cpuinfo/{cpuid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByCpuId(@PathVariable("cpuid")Integer cpuid) {
        Cpuinfo cpuinfo = cpuinfoService.getByCpuId(cpuid);
        return Msg.success().add("cpuinfo", cpuinfo);
    }
}
