package com.itheima.dao;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll ();
    void saveProduct(Product product);
    Product findById(String id);
    void update(Product product);
    Product findByNum(String num);
    void delete(String id);
    void openById(String id);
    void closeById(String id);
    Integer findCount();
}
