package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.UserDao;
import com.itheima.domain.Page;
import com.itheima.domain.QueryBean;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        List<Role> roles = userInfo.getRoles();
        List<SimpleGrantedAuthority> simpleGrantedAuthorities=new ArrayList<>();
        for (Role role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        User user=new User(username,userInfo.getPassword(),simpleGrantedAuthorities);
        return user;
    }
    @Override
    public List<UserInfo> findAll(Page page){
        PageHelper.startPage(page.getPage(),page.getPageSize());
        List<UserInfo> list = userDao.findAll();
        return list;
    }

    @Override
    public void save(UserInfo user) {
        userDao.saveUser(user);
    }

    @Override
    public UserInfo findByUsername(String username) {
       return userDao.findByName(username);
    }

    @Override
    public void addRole(QueryBean qb) {
       userDao.addRole(qb);
    }

    @Override
    public void deleteRole(QueryBean qb) {
        userDao.deleteRole(qb);
    }

    @Override
    public void updateRole(String uid,String[] rids) {
        QueryBean queryBean = new QueryBean();
        queryBean.setUid(uid);
        userDao.deleteRoleByUid(uid);
        for (String rid : rids) {
            queryBean.setRid(rid);
            userDao.addRole(queryBean);
        }
    }


}
