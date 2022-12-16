package com.aspect;

import com.alibaba.fastjson.JSON;
import com.annotation.MyLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author luo
 * @date 2022/12/16 14:48
 */
@Aspect
@Slf4j
@Component
public class LogAspect {
    @Pointcut("execution (* com.web.controller.*Controller.*(..))")
    public void controllerAspect() {
    }

    //@Around("@annotation(com.annotation.MyLog)")
    @Around(("controllerAspect()"))
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("----- doAround ---- ");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        String name = methodSignature.getName();
        Method targetMethod = methodSignature.getMethod();
        MyLog myLog = targetMethod.getAnnotation(MyLog.class);
        log.info("方法：{},自定义打印 : {}", name, myLog.printLog());
        log.info("方法：{},请求参数 : {}", name, JSON.toJSONString(args));
        log.info("方法：{},返回参数 : {}", name, JSON.toJSONString(joinPoint.proceed()));
        return joinPoint.proceed();
    }

    @Before("controllerAspect()")
    public void before(JoinPoint joinPoint) throws Throwable {
        log.info("----- before ---- ");
        Object[] arguments = joinPoint.getArgs();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String printLog = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class<?>[] clazz = method.getParameterTypes();
                if (clazz.length == arguments.length) {
                    if (method.getAnnotation(MyLog.class) != null) {
                        printLog = method.getAnnotation(MyLog.class).printLog();
                    }
                    break;
                }
            }
        }
        log.info("printLog : {}", printLog);
        log.info("joinPoint name : {}", joinPoint.getTarget().getClass().getName());
        log.info("params : {}", JSON.toJSONString(arguments));
    }

    @After("controllerAspect()")
    public void after(JoinPoint joinPoint) throws Throwable {
        log.info("----- after ---- ");
        Object[] arguments = joinPoint.getArgs();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String printLog = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class<?>[] clazz = method.getParameterTypes();
                if (clazz.length == arguments.length) {
                    if (method.getAnnotation(MyLog.class) != null) {
                        printLog = method.getAnnotation(MyLog.class).printLog();
                    }
                    break;
                }
            }
        }
        log.info("printLog : {}", printLog);
        log.info("joinPoint name : {}", joinPoint.getTarget().getClass().getName());
        log.info("params : {}", JSON.toJSONString(arguments));
    }

}
