package com.demo.spring4.chapter01.aop.service;


import com.demo.spring4.chapter01.aop.annotation.Action;

public class DemoAnnotationService {

    @Action(name = "注解拦截add操作")
    public void add() {
    }
}
