package com.itheima.dao;

import com.itheima.domain.Page;
import com.itheima.domain.QueryBean;
import com.itheima.domain.UserInfo;

import java.util.List;

public interface UserDao {
    UserInfo findByUsername(String username);
    List<UserInfo> findAll();
    void saveUser(UserInfo user);
    void addRole(QueryBean qb);
    void deleteRole(QueryBean qb);
}
