package com.jf.crud.controller;

import com.jf.crud.bean.Size;
import com.jf.crud.service.SizeService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class SizeController {
    @Autowired
    SizeService sizeService;
    /**
     * 获取所有size表信息
     */
    @RequestMapping(value = "/sizes")
    @ResponseBody
    public Msg getSizesWithJson() {
        List<Size> sizes = sizeService.getAll();
        return Msg.success().add("sizes", sizes);
    }
    /**
     * 根据cpuId查询
     */
    @RequestMapping(value = "/size/{sizeid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getBySizeId(@PathVariable("sizeid")Integer sizeid) {
        Size size = sizeService.getBySizeId(sizeid);
        return Msg.success().add("size", size);
    }
}
