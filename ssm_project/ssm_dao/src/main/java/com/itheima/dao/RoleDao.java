package com.itheima.dao;

import com.itheima.domain.QueryBean;
import com.itheima.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findByUserId(String uid);
    List<Role> findAll();
    Role findById(String rid);
    void save(Role role);
    void addPermission(QueryBean qb);
    void deletePermission(QueryBean qb);
}
