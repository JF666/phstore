package com.jf.crud.controller;

import com.jf.crud.bean.Recognition;
import com.jf.crud.service.RecognitionService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class RecognitionController {
    @Autowired
    RecognitionService recognitionService;
    /**
     * 获取所有recognition表信息
     */
    @RequestMapping(value = "/recognitions")
    @ResponseBody
    public Msg getRecognitionsWithJson() {
        List<Recognition> recognitions = recognitionService.getAll();
        return Msg.success().add("recognitions", recognitions);
    }
    /**
     * 根据cpuId查询
     */
    @RequestMapping(value = "/recognition/{recid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByRecId(@PathVariable("recid")Integer recid) {
        Recognition recognition = recognitionService.getByRecId(recid);
        return Msg.success().add("recognition", recognition);
    }
}
