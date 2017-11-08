package com.demo.spring4.chapter01.javaconfig;

import com.demo.spring4.chapter01.javaconfig.dao.FunctionDao;
import com.demo.spring4.chapter01.javaconfig.service.impl.FunctionServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @title <p>Java 配置类配置Bean 演示案例<p>
 * @desc 涉及到的注解 @Configuration | @Bean | @Scope
 * @author Panlibin2015
 * @date 2017-11-8
 */
public class JavaConfigTest {
    @Test
    public void paramInject() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        FunctionServiceImpl serviceParam = (FunctionServiceImpl) context.getBean("functionServiceByParam");
        FunctionDao functionDaoFromServiceParam = serviceParam.getFunctionDao();

        FunctionServiceImpl service = (FunctionServiceImpl) context.getBean("functionService");
        FunctionDao functionDaoFromService = service.getFunctionDao();

        FunctionDao functionDao = (FunctionDao) context.getBean("functionDao");

        System.out.println("from param:" + (functionDao == functionDaoFromServiceParam));// true
        System.out.println("from method:" + (functionDao == functionDaoFromService));// true

        context.close();
    }

    @Test
    public void initAndDestory() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        context.getBean("functionServiceWithInitAndDestory");
    }

    /**
     * 单利 多例测试
     */
    @Test
    public void singletonAndPrototype() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        FunctionDao daoSingleton1 = (FunctionDao) context.getBean("functionDaoSingleton");
        FunctionDao daoSingleton2 = (FunctionDao) context.getBean("functionDaoSingleton");
        System.out.println("singleton:" + (daoSingleton1 == daoSingleton2));

        FunctionDao daoPrototype1 = (FunctionDao) context.getBean("functionDaoPrototype");
        FunctionDao daoPrototype2 = (FunctionDao) context.getBean("functionDaoPrototype");
        System.out.println("prototype:" + (daoPrototype1 == daoPrototype2));
    }
}
