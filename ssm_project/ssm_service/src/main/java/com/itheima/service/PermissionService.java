package com.itheima.service;

import com.itheima.domain.Page;
import com.itheima.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll(Page page);
    List<Permission> findAll();
    void save(Permission permission);
}
