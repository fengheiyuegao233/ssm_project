package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.RoleDao;
import com.itheima.domain.Page;
import com.itheima.domain.QueryBean;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll(Page page) {
        PageHelper.startPage(page.getPage(),page.getPageSize());
        List<Role> all = roleDao.findAll();
        return all;
    }
    @Override
    public List<Role> findAll(){
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(String rid) {
        Role role = roleDao.findById(rid);
        return role;
    }

    @Override
    public void addPermission(QueryBean qb) {
        roleDao.addPermission(qb);
    }

    @Override
    public void deletePermission(QueryBean qb) {
        roleDao.deletePermission(qb);
    }

}
