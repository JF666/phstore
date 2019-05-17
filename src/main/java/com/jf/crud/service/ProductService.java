package com.jf.crud.service;

import com.jf.crud.bean.Product;
import com.jf.crud.bean.ProductExample;
import com.jf.crud.dao.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    public List<Product> getAll() {
        List<Product> products = productMapper.selectByExample(null);
        return products;
    }
    public Boolean insertProduct(Product product) {
        return productMapper.insertSelective(product)!=0;
    }
    public List<Product> getBySellerId(Integer sellerid) {
        List<Product> products = productMapper.selectBySellerId(sellerid);
        return products;
    }
    public List<Product> getByProName(String proname) {
        List<Product> product = productMapper.selectByProName(proname);
        return product;
    }
    public Product getByProId(Integer proid) {
        return productMapper.selectByPrimaryKey(proid);
    }
    public void UpdateProduct(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }
    public void DeleteProduct(Integer proid) {
        productMapper.deleteByPrimaryKey(proid);
    }
    public void DeleteBatch(List<Integer> proids) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProidIn(proids);
        productMapper.deleteByExample(productExample);
    }
}