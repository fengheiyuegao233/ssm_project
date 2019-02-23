package com.itheima.controller;

import com.itheima.domain.Page;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll")
    public String findAll(Map map,Page page){
        Page<Product> pages = productService.findAll(page);
        map.put("pages",pages);
        return "product-list";
    }
    @RequestMapping("/save")
    @RolesAllowed({"ADMIN","SYSTEM"})
    public String saveProduct(Product product){
        productService.save(product);
        return "redirect: findAll";
    }
    @RequestMapping("/update")
    @RolesAllowed({"ADMIN","SYSTEM"})
    public String updateProduct(Product product){
        productService.update(product);
        return "redirect: findAll";
    }
    @RequestMapping("/toUpdate")
    @RolesAllowed({"ADMIN","SYSTEM"})
    public String toUpdateProduct(String num,Map map){
        Product product = productService.findByNum(num);
        map.put("product",product);
        return "product-update";
    }
    @RequestMapping("/show")
    public String toShow(String num,Map map){
        Product product = productService.findByNum(num);
        map.put("product",product);
        return "product-show";
    }
    @RequestMapping("/delete")
    @RolesAllowed({"ADMIN","SYSTEM"})
    public String delete( String[] pid){
        System.out.println(pid);
      productService.delete(pid);

        return "redirect: findAll";
    }
    @RequestMapping("/open")
    @RolesAllowed({"ADMIN","SYSTEM"})
    public String open(Map map, String[] pid){
        System.out.println(pid);
        productService.openById(pid);

        return "redirect: findAll";
    }
    @RequestMapping("/close")
    @RolesAllowed({"ADMIN","SYSTEM"})
    public String close( String[] pid){
        System.out.println(pid);
        productService.closeById(pid);

        return "redirect: findAll";
    }
}
