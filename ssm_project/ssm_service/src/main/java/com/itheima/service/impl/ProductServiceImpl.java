package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Page;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Page<Product> findAll(Page page) {
//
        PageHelper.startPage(page.getPage(),page.getPageSize());
        List<Product> list = productDao.findAll();
        page.setTotelSize(productDao.findCount());
        page.setList(list);
        return page;
//
    }

    @Override
    public void save(Product product) {
        System.out.println(product);
        productDao.saveProduct(product);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public Product findByNum(String num) {
       return productDao.findByNum(num);
    }

    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            productDao.delete(id);
        }
    }

    @Override
    public void openById(String[] ids) {
        for (String id : ids) {
            productDao.openById(id);
        }
    }

    @Override
    public void closeById(String[] ids) {
        for (String id : ids) {
            productDao.closeById(id);
        }
    }

}
