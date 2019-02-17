package com.itheima.controller;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll")
    public String findAll(Map map){
        List<Product> productList = productService.findAll();
        map.put("productList",productList);
        return "product-list";
    }
    @RequestMapping("/save")

    public String saveProduct(Product product){
        productService.save(product);
        return "redirect: findAll";
    }
}
