package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path")
public class PathController {
    @RequestMapping("/pathname/{name}")
    public String toPath(@PathVariable("name") String name){
        return name;
    }
}
