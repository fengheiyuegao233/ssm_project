package com.itheima.dao;

import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.aspectj.weaver.ast.Or;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrdersDao {
    List<Orders> findAll();
    Integer findCount();
    Orders findByNum(String num);

}
