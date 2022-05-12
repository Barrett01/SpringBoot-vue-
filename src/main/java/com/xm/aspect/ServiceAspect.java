package com.xm.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    private Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

    @Pointcut("execution(public * com.example.mall.service.*.*(..))")
    public void pointcut(){

    }

    // 环绕通知
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        //目标方法执行，res保存目标方法的返回值
        Object res = joinPoint.proceed();
        logger.info("【服务层方法】: {}----【执行时间】{} 毫秒",
                        joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName(),
                        System.currentTimeMillis() - startTime
                );
        return res;
    }
}
