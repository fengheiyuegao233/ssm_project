package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.dao.UserDao;
import com.itheima.domain.Page;
import com.itheima.domain.QueryBean;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @RequestMapping("/findAll")
    @RolesAllowed({"ADMIN","SYSTEM"})
    public String findAll(Page page,Map map){
        List<UserInfo> all = userService.findAll(page);
        PageInfo pageInfo=new PageInfo(all);
        map.put("pageInfo",pageInfo);
        return "user-list";
    }
    @RequestMapping("/save")
    @RolesAllowed({"SYSTEM"})
    public String save(UserInfo user,Map map){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect: findAll";
    }
    @RequestMapping("/show")
    @RolesAllowed({"ADMIN","SYSTEM"})
    public String show(String username,Map map){
        UserInfo user = userService.findByUsername(username);
        map.put("user",user);
        return "user-show";
    }
    @RequestMapping("/addRole")
    @RolesAllowed({"SYSTEM"})
    public String findUserByUsernameAndAllRole(String username,Map map){
        UserInfo user = userService.findByUsername(username);

        List<Role> list = roleService.findAll();
        map.put("user",user);
        map.put("roleList",list);
        return "user-role-add";
    }
    @RequestMapping("/saveAddRole")
    @RolesAllowed({"SYSTEM"})
    public String addRole(QueryBean qb,String[] rids, Map map){
        for (String rid : rids) {
            qb.setRid(rid);
            userService.addRole(qb);
        }
        return "redirect: findAll";
    }
    @RequestMapping("/deleteRole")
    @RolesAllowed({"SYSTEM"})
    public String findUserByUsername(String username,Map map){
        UserInfo user = userService.findByUsername(username);
        map.put("user",user);
        return "user-role-delete";
    }
    @RequestMapping("/saveDeleteRole")
    @RolesAllowed({"SYSTEM"})
    public String DeleteRole(QueryBean qb, String[] rids, Map map){
        for (String rid : rids) {

            qb.setRid(rid);
            userService.deleteRole(qb);
        }
        return "redirect: findAll";
    }
    @RequestMapping("/updateRole")
    @RolesAllowed({"SYSTEM"})
    public String toUpdateByUsername(String username,Map map){
        UserInfo user = userService.findByUsername(username);
        List<Role> list = roleService.findAll();
        for (Role role : list) {
            if (user.getRoles().contains(role)){
                role.setFlag(true);
            }
        }
        map.put("user",user);
        map.put("roleList",list);
        return "user-role-update";
    }
    @RequestMapping("/saveUpdateRole")
    @RolesAllowed({"SYSTEM"})
    public String UpdateRole(String uid, String[] rids, Map map){
        userService.updateRole(uid,rids);
        return "redirect: findAll";
    }
}
