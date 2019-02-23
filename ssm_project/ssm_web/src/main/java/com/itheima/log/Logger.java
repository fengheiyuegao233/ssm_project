package com.itheima.log;

import com.itheima.controller.SysLogController;
import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.security.Security;
import java.util.Date;
import java.util.Map;

@Component("logger")
public class Logger {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogService sysLogService;
    private Date startTime; // 访问时间
    private Class executionClass;// 访问的类
    private Method executionMethod; // 访问的方法

    public void doBefore(JoinPoint jp) throws Exception{
        startTime=new Date();
        executionClass=jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if (args==null || args.length==0){
            executionMethod=executionClass.getMethod(methodName);
        }else {
            Class[] classes=new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                Class aClass = args[i].getClass();
                if (aClass.getName().equals("org.springframework.validation.support.BindingAwareModelMap")){
                  aClass= Map.class;
              }
                classes[i]=aClass;
            }
            executionMethod=executionClass.getMethod(methodName,classes);
        }
    }
    public void doAfter(JoinPoint jp) throws Exception{
        if (!(jp.getTarget() instanceof SysLogController)) {
            SysLog sysLog = new SysLog();
            sysLog.setUrl(request.getServletPath());
            sysLog.setIp(request.getRemoteAddr());
            sysLog.setVisitTime(startTime);
            sysLog.setMethod("[类名]:" + executionClass.getName() + "  [方法名]:" + executionMethod.getName());
            SecurityContext context = SecurityContextHolder.getContext();
            User user = (User) (context.getAuthentication().getPrincipal());
            Long executionTime = new Date().getTime() - startTime.getTime();
            sysLog.setExecutionTime(executionTime);
            sysLog.setUsername(user.getUsername());
            System.out.println("==============" + sysLog + "==============");
            sysLogService.save(sysLog);
        }
    }
}
