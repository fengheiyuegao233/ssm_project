package com.itheima.service;

import com.itheima.domain.Page;
import com.itheima.domain.QueryBean;
import com.itheima.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {
    List<Role> findAll(Page page);
    List<Role> findAll();
    void save(Role role);
    Role findById(String rid);
    void addPermission(QueryBean qb);
    void deletePermission(QueryBean qb);
}
