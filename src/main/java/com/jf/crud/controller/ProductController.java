package com.jf.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jf.crud.bean.Product;
import com.jf.crud.service.ProductService;
import com.jf.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {
    @Autowired
    ProductService productService;
    /**
     * 获取所有product表信息
     */
    @RequestMapping(value = "/products")
    @ResponseBody
    public Msg getProductsWithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn) {
        PageHelper.startPage(pn, 8);
        List<Product> products = productService.getAll();
        PageInfo page = new PageInfo(products, 5);
        return Msg.success().add("pageInfo", page);
    }
    /**
     * 获取所有product信息
     */
    @RequestMapping(value = "/allProduct")
    @ResponseBody
    public Msg getAllProduct() {
        List<Product> products = productService.getAll();
        return Msg.success().add("pageInfo", products);
    }
    /**
     * 新增一条product记录
     */
    @RequestMapping(value = "/productInsert",method = RequestMethod.POST)
    @ResponseBody
    public Msg insertProduct(@Valid Product product) {
        if (productService.insertProduct(product)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    /**
     * 根据sellerId查询
     */
    @RequestMapping(value = "/product/{sellerid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getBySellerId(@PathVariable("sellerid")Integer sellerid) {
        List<Product> products = productService.getBySellerId(sellerid);
        return Msg.success().add("products", products);
    }
    /**
     * 根据proname查询
     */
    @RequestMapping(value = "/probyname/{proname}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByProName(@PathVariable("proname")String proname) {
        List<Product> product = productService.getByProName(proname);
        return Msg.success().add("product", product);
    }
    /**
     * 根据proid查询
     */
    @RequestMapping(value = "/probyId/{proid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getByProId(@PathVariable("proid")Integer proid) {
        Product product = productService.getByProId(proid);
        return Msg.success().add("product", product);
    }
    /**
     * 根据proId修改更新
     */
    @RequestMapping(value = "/product/{proid}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg UpdateProduct(Product product) {
        productService.UpdateProduct(product);
        return Msg.success();
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/product/{proids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg DeleteProduct(@PathVariable("proids")String proids) {
        if (proids.contains("_")) {
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = proids.split("_");
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            productService.DeleteBatch(del_ids);
        } else {
            productService.DeleteProduct(Integer.parseInt(proids));
        }
        return Msg.success();
    }
}