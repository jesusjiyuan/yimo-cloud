package com.yimo.common.core.config;

import com.alibaba.fastjson2.JSON;
import com.yimo.common.core.utils.ip.IpUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class ApiLogAspect {
    private static final Logger log = LoggerFactory.getLogger(ApiLogAspect.class);

    public ApiLogAspect() {
    }

    @Pointcut("execution(public * com.*.*.controller..*.*(..))")
    public void apilog() {
    }

    @Around("apilog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        log.info("========================================== Start ==========================================");
        log.info("URL            : {}", request.getRequestURL().toString());
        log.info("HTTP Method    : {}", request.getMethod());
        log.info("Class Method   : {}.{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
        log.info("IP             : {}", IpUtils.getIpAddr(request));
        log.info("Req Args       : {}", proceedingJoinPoint.getArgs().length < 1 ? JSON.toJSONString(proceedingJoinPoint.getArgs()) : proceedingJoinPoint.getArgs());
        Object result = proceedingJoinPoint.proceed();
        String str = JSON.toJSONString(result);
        log.info("Resp status    : {}", response.getStatus());
        if (log.isDebugEnabled()) {
            log.debug("Resp result    : {}", str);
        } else {
            log.info("Resp result    : {}", str.length() < 200 ? str : str.substring(0, 200));
        }

        log.info("Time-cost      : {} ms", System.currentTimeMillis() - startTime);
        log.info("=========================================== End ===========================================" + System.lineSeparator());
        return result;
    }
}