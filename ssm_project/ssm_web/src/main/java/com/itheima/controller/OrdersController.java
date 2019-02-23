package com.itheima.controller;

import com.itheima.domain.Orders;
import com.itheima.domain.Page;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/findAll")
    public String findAll(Map map, Page page){
        System.out.println(page);
        Page<Orders> pages = ordersService.findAll(page);
        map.put("pages",pages);
        return "orders-list";
    }
    @RequestMapping("/find")
    @RolesAllowed({"ADMIN","SYSTEM"})
    public String find(Map map,String num){
        Orders orders = ordersService.findByNum(num);
        map.put("orders",orders);
        return "orders-show";
    }

}
