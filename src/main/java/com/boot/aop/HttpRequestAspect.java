package com.boot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class HttpRequestAspect {

    @Pointcut("execution(public * com.boot.services.*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @Around("pointCut()")
    public Object logAll(ProceedingJoinPoint joinPoint){
        Object result = null;
        // 执行方法名
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Long start = 0L;
        Long end = 0L;
        String ip = null;
        // 当前用户
        try {
            // 执行方法所消耗的时间
            start = System.currentTimeMillis();
            result = joinPoint.proceed();
            end = System.currentTimeMillis();
            // ip
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        log.info("className:" + className);
        log.info("methodName:" + methodName);
        log.info("costTime:" + (end-start));
        log.info("ip:" + ip);
        return result;
    }

    @AfterReturning(returning = "ret", pointcut = "pointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
    }

}
