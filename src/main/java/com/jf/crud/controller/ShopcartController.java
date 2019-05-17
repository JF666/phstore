package com.jf.crud.controller;

import com.jf.crud.bean.Shopcart;
import com.jf.crud.service.ShopcartService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopcartController {
    @Autowired
    ShopcartService shopcartService;
    /**
     * 获取所有shopcart表信息
     */
    @RequestMapping(value = "/shopcarts")
    @ResponseBody
    public Msg getAll() {
        List<Shopcart> shopcarts = shopcartService.getAll();
        return Msg.success().add("shopcarts", shopcarts);
    }
    /**
     * 加入购物车
     */
    @RequestMapping(value = "/shopcartInsert",method = RequestMethod.POST)
    @ResponseBody
    public Msg insertShopcart(Shopcart shopcart) {
        if (shopcartService.insertShopcart(shopcart)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    /**
     * 根据buyerId查询
     */
    @RequestMapping(value = "/shopcartBuyer/{buyerid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByBuyerId(@PathVariable("buyerid")Integer buyerid) {
        List<Shopcart> shopcarts = shopcartService.getByBuyerId(buyerid);
        return Msg.success().add("shopcarts", shopcarts);
    }
    /**
     * 查询数量
     */
    @RequestMapping(value = "/proCount", method = RequestMethod.GET)
    @ResponseBody
    public Msg proCount(Integer buyerId, Integer proId, String color) {
        Map<String, Object> params = new HashMap<>();
        params.put("buyerId", buyerId);
        params.put("proId", proId);
        params.put("color", color);
        Integer proNum = shopcartService.proCount(params);
        return Msg.success().add("proNum", proNum);
    }
    /**
     * 根据shopcartid修改更新
     */
    @RequestMapping(value = "/updateAmount", method = RequestMethod.PUT)
    @ResponseBody
    public Msg UpdateShopcart(Integer buyerId, Integer proId, String color, Integer amount) {
        Map<String, Object> params = new HashMap<>();
        params.put("buyerId", buyerId);
        params.put("proId", proId);
        params.put("color", color);
        params.put("amount", amount);
        if (shopcartService.updateAmount(params)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/shopcart/{shopcartids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg DeleteShopcart(@PathVariable("shopcartids")String shopcartids) {
        if (shopcartids.contains(",")) {
            List<Integer> del_shopcartids = new ArrayList<>();
            String[] str_shopcartids = shopcartids.split(",");
            for (String string : str_shopcartids) {
                del_shopcartids.add(Integer.parseInt(string));
            }
            shopcartService.DeleteBatch(del_shopcartids);
        } else {
            shopcartService.DeleteShopcart(Integer.parseInt(shopcartids));
        }
        return Msg.success();
    }
}