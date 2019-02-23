package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Page;
import com.itheima.domain.SysLog;
import com.itheima.domain.UserInfo;
import com.itheima.service.SysLogService;
import com.itheima.service.impl.SysLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;
    @RequestMapping("/findAll")
    public String findAll(Page page, Map map){
        List<SysLog> all = sysLogService.findAll(page);
        PageInfo pageInfo=new PageInfo(all);
        map.put("pageInfo",pageInfo);
        return "syslog-list";
    }
    @RequestMapping("/delete")
    public String delete(){
       sysLogService.deleteAll();
        return "syslog-list";
    }

}
