package com.jf.crud.controller;

import com.jf.crud.bean.Operatingsys;
import com.jf.crud.service.OperatingsysService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class OperatingsysController {
    @Autowired
    OperatingsysService operatingsysService;
    /**
     * 获取所有operatingsys表信息
     */
    @RequestMapping(value = "/operatingsyss")
    @ResponseBody
    public Msg getOperatingsyssWithJson() {
        List<Operatingsys> operatingsyss = operatingsysService.getAll();
        return Msg.success().add("operatingsyss", operatingsyss);
    }
    /**
     * 根据cpuId查询
     */
    @RequestMapping(value = "/operatingsys/{osid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByOsId(@PathVariable("osid")Integer osid) {
        Operatingsys operatingsys = operatingsysService.getByOsId(osid);
        return Msg.success().add("operatingsys", operatingsys);
    }
}
