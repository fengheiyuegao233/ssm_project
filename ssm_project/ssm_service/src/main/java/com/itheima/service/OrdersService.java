package com.itheima.service;

import com.itheima.domain.Orders;
import com.itheima.domain.Page;

import java.util.List;

public interface OrdersService {
    Page<Orders> findAll(Page page);
    Orders findByNum(String num);
}
