package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Page;
import com.itheima.domain.Permission;
import com.itheima.domain.QueryBean;
import com.itheima.domain.Role;
import com.itheima.service.PermissionService;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")

public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findAll")
    public String findAll(Page page,Map map){
        List<Role> list = roleService.findAll(page);
        PageInfo pageInfo=new PageInfo(list);
        map.put("pageInfo",pageInfo);
        return "role-list";
    }
    @RequestMapping("/save")
    @RolesAllowed({"SYSTEM"})
    public String save(Role role,Map map){
        roleService.save(role);
        return "redirect: findAll";
    }
    @RequestMapping("/AddPermission")
    @RolesAllowed({"SYSTEM"})
    public String addPermission(String rid, Map map){
        Role role = roleService.findById(rid);
        List<Permission> list = permissionService.findAll();
        map.put("role",role);
        map.put("permissionList",list);
        return "role-permission-add";
    }
    @RequestMapping("/saveAddPermission")
    @RolesAllowed({"SYSTEM"})
    public String saveAddRole(QueryBean qb,String[] pids, Map map){
        for (String pid : pids) {
            if (!(pid==null)) {
                qb.setPid(pid);
                roleService.addPermission(qb);
            }
        }

        return "redirect: findAll";
    }
    @RequestMapping("/deletePermission")
    @RolesAllowed({"SYSTEM"})
    public String deletePermission(String rid, Map map){
        Role role = roleService.findById(rid);
        map.put("role",role);
        return "role-permission-delete";
    }
    @RequestMapping("/saveDeletePermission")
    @RolesAllowed({"SYSTEM"})
    public String saveDeleteRole(QueryBean qb, String[] pids, Map map){
        for (String pid : pids) {
            if (!(pid==null)) {
                qb.setPid(pid);
                roleService.deletePermission(qb);
            }
        }
        return "redirect: findAll";
    }
}
