package com.demo.spring4.chapter01.aop.service;

import com.demo.spring4.chapter01.aop.annotation.Action;
import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
    @Action(name = "注解拦截add方法")
    public void add() {
    }
}
