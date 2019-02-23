package com.itheima.dao;

import com.itheima.domain.SysLog;

import java.util.List;

public interface SysLogDao {
    List<SysLog> findAll();
    void save(SysLog sysLog);
    void deleteAll();
}
