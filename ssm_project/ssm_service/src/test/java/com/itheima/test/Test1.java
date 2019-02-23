package com.itheima.test;

import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring_service.xml");
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        System.out.println(userService.findByUsername("wudi"));
//        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("wudi"));
        System.out.println(String.class);
        System.out.println(new String[10].getClass());
    }
}
