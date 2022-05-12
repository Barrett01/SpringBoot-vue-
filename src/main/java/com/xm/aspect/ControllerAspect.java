package com.xm.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component //标注为组件,可被实例化
@Aspect //标注为切面
public class ControllerAspect {
    private Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    //切入点execution表达式, 这里表示切入点为controller包下的所有方法
    @Pointcut("execution(public * com.example.mall.controller.*.*(..))")
    public void pointcut(){

    }
    //这是一个前置通知，该方法在目标方法执行之前执行
    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint){
        //收到请求,记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //请求方法
        String requestMethod = request.getMethod();
        //请求url
        String url = request.getRequestURL().toString();
        //请求接口的名称
        String apiName = joinPoint.getTarget().getClass().getName()  + "." +
                joinPoint.getSignature().getName();
        //请求中的参数，参数可能有多个
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("【请求方法】:{}, 【请求URL】:{}, 【请求接口方法】:{}, 【请求参数】:{}", requestMethod, url, apiName, args);
    }

    //这是一个返回通知，在该方法中可以获取目标方法的返回值
    @AfterReturning(value = "pointcut()", returning = "res")
    public void doAfterReturning(Object res){
        try {
            //把返回的对象转化为字符串
            String resString = new ObjectMapper().writeValueAsString(res);
            logger.info("【方法返回数据】:{}", resString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

