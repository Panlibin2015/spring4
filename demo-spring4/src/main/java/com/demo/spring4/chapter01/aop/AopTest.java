package com.demo.spring4.chapter01.aop;

<<<<<<< HEAD
public class AopTest {
=======
import com.demo.spring4.chapter01.aop.service.DemoAnnotationService;
import com.demo.spring4.chapter01.aop.service.DemoMethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfiguration.class);
        DemoAnnotationService annoService = (DemoAnnotationService) context.getBean("demoAnnotationService");
        DemoMethodService methodService = (DemoMethodService) context.getBean("demoMethodService");
        annoService.add();
        methodService.add();
        context.close();
    }
>>>>>>> temp
}
