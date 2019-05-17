package com.jf.crud.controller;

import com.jf.crud.bean.Seller;
import com.jf.crud.service.SellerService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class SellerController {
    @Autowired
    SellerService sellerService;
    /**
     * 获取所有Seller表信息
     */
    @RequestMapping(value = "/sellers")
    @ResponseBody
    public Msg getAll() {
        List<Seller> sellers = sellerService.getAll();
        return Msg.success().add("sellers", sellers);
    }
    /**
     * 根据sellerid查询
     */
    @RequestMapping(value = "/seller/{sellerid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getBySellerId(@PathVariable("sellerid")Integer sellerid) {
        Seller seller = sellerService.getBySellerId(sellerid);
        return Msg.success().add("seller", seller);
    }
    /**
     * 根据userid查询
     */
    @RequestMapping(value = "/sellerByUser/{userid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByUserId(@PathVariable("userid")Integer userid) {
        Seller seller = sellerService.getByUserId(userid);
        return Msg.success().add("seller", seller);
    }
    /**
     * 新增
     */
    @RequestMapping(value = "/sellerInsert",method = RequestMethod.POST)
    @ResponseBody
    public Msg insertSeller(@Valid Seller seller) {
        if (sellerService.insertSeller(seller)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    /**
     * 根据id修改更新
     */
    @RequestMapping(value = "/seller/{userid}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg UpdateSeller(Seller seller) {
        sellerService.UpdateSeller(seller);
        return Msg.success();
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/seller/{userids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg DeleteSeller(@PathVariable("userids")String userids) {
        if (userids.contains("~")) {
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = userids.split("~");
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            sellerService.DeleteBatch(del_ids);
        } else {
            sellerService.DeleteSeller(Integer.parseInt(userids));
        }
        return Msg.success();
    }
}
