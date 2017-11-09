package com.demo.spring4.chapter02.springaware;

import com.demo.spring4.chapter02.springaware.service.AwareService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResoult();
        context.close();
    }
}
