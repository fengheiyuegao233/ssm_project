package com.itheima.service;

import com.itheima.domain.Page;
import com.itheima.domain.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    Page<Product> findAll(Page page);
    void save(Product product);
    void update(Product product);
    Product findByNum(String Num);
    void delete(String[] ids);
    void openById(String[] ids);
    void closeById(String[] ids);
}
