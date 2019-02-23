package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.OrdersDao;
import com.itheima.domain.Orders;
import com.itheima.domain.Page;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public Page<Orders> findAll(Page page) {
        PageHelper.startPage(page.getPage(),page.getPageSize());
        List<Orders> list = ordersDao.findAll();
        page.setTotelSize(ordersDao.findCount());
        page.setList(list);
        return page;
    }

    @Override
    public Orders findByNum(String num) {
       return ordersDao.findByNum(num);
    }
}
