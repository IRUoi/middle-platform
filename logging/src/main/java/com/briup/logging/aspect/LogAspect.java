package com.briup.logging.aspect;

import com.briup.common.web.util.JwtUtil;
import com.briup.logging.service.ILogService;
import com.briup.user.bean.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/18/2022-11-18-2:11 AM
 * @Description：com.briup.logging.aspect
 */
@Aspect
@Component
public class LogAspect {
    @Autowired
    private ILogService logService;
    //定义切入点
    @Pointcut("execution(* com.briup..web.controller.*.*(..)) && @annotation(com.briup.logging.anno.LoggingAccess)")
    public void pointcut(){}
    //环绕通知

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp){
        System.out.println("LogAspect");

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        String token = request.getHeader("Authorization");
        Map<String, Object> info = JwtUtil.getInfo(token);

        Log log = Log.builder()
                .logUsername((String) info.get("username"))
                .logRealname((String) info.get("realname"))
                .logRequestMethod(request.getMethod())
                .logRequestUri(request.getRequestURI())
                .logTime(new Date())
                .build();
        try {
            logService.add(log);
            return pjp.proceed(pjp.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
