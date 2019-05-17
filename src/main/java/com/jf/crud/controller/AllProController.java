package com.jf.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jf.crud.bean.Allpro;
import com.jf.crud.bean.Product;
import com.jf.crud.service.AllProService;
import com.jf.crud.service.ProductService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class AllProController {
    @Autowired
    AllProService allProService;
    /**
     * 获取所有product表信息
     */
    @RequestMapping(value = "/allPro")
    @ResponseBody
    public Msg getAll(@RequestParam(value = "pn",defaultValue = "1")Integer pn) {
        PageHelper.startPage(pn, 10);
        List<Allpro> allpros = allProService.getAll();
        PageInfo page = new PageInfo(allpros, 5);
        return Msg.success().add("pageInfo", page);
    }
    /**
     * 模糊查询
     */
    @RequestMapping(value = "/FuzzyQuery")
    @ResponseBody
    public Msg fuzzyQuery(@RequestParam(value = "pn",defaultValue = "1")Integer pn,String key) {
        PageHelper.startPage(pn, 10);
        List<Allpro> products = allProService.fuzzyQuery(key);
        PageInfo page = new PageInfo(products, 5);
        return Msg.success().add("pageInfo", page);
    }
}