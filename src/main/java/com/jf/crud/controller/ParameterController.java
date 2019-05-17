package com.jf.crud.controller;

import com.jf.crud.bean.Parameter;
import com.jf.crud.service.ParameterService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class ParameterController {
    @Autowired
    ParameterService parameterService;
    /**
     * 获取所有Parameter表信息
     */
    @RequestMapping(value = "/parameters")
    @ResponseBody
    public Msg getParameters() {
        List<Parameter> parameters = parameterService.getAll();
        return Msg.success().add("parameters", parameters);
    }
    /**
     * 新增一条Parameter记录
     */
    @RequestMapping(value = "/parameterInsert",method = RequestMethod.POST)
    @ResponseBody
    public Msg insertParameter(@Valid Parameter parameter) {
        if (parameterService.insertParameter(parameter)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    /**
     * 根据proId查询
     */
    @RequestMapping(value = "/parameter/{proid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByProId(@PathVariable("proid")Integer proid) {
        List<Parameter> parameter = parameterService.getByProId(proid);
        return Msg.success().add("parameter", parameter);
    }
    /**
     * 根据proId修改更新
     */
    @RequestMapping(value = "/parameter/{proid}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg UpdateParameter(Parameter parameter) {
        parameterService.UpdateParameter(parameter);
        return Msg.success();
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/parameter/{proids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg DeleteParameter(@PathVariable("proids")String proids) {
        if (proids.contains("#")) {
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = proids.split("#");
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            parameterService.DeleteBatch(del_ids);
        } else {
            parameterService.DeleteParameter(Integer.parseInt(proids));
        }
        return Msg.success();
    }
}
