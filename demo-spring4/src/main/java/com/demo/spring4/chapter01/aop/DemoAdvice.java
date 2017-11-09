package com.demo.spring4.chapter01.aop;

import com.demo.spring4.chapter01.aop.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DemoAdvice {
    @Pointcut("@annotation(com.demo.spring4.chapter01.aop.annotation.Action)")
    public void annotationPointCut() {
    }

    @Pointcut("execution(* com.demo.spring4.chapter01.aop.service.DemoMethodService.*(..))")
    public void methodPointCut() {
    }

    @After("annotationPointCut()")
    public void afterAdd(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解规则拦截," + action.name());
    }

    @Before("methodPointCut()")
    public void beforeAdd(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则拦截," + method.getName());
    }
}
