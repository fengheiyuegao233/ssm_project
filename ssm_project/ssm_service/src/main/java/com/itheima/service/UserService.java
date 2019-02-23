package com.itheima.service;

import com.itheima.domain.Page;
import com.itheima.domain.QueryBean;
import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll(Page page);
    void save(UserInfo user);
    UserInfo findByUsername(String username);
    void addRole(QueryBean qb);
    void deleteRole(QueryBean qb);

}
