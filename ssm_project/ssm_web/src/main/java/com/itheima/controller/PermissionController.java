package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Page;
import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findAll")
    public String findAll(Page page, Map map){
        List<Permission> list = permissionService.findAll(page);
        PageInfo pageInfo=new PageInfo(list);
        map.put("pageInfo",pageInfo);
        return "permission-list";
    }
    @RequestMapping("/save")
    @RolesAllowed({"SYSTEM"})
    public String save(Permission permission, Map map){
        permissionService.save(permission);
        return "redirect: findAll";
    }
}
