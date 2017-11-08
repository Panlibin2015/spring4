package com.demo.spring4.chapter01.javaconfig;

import com.demo.spring4.chapter01.javaconfig.dao.FunctionDao;
import com.demo.spring4.chapter01.javaconfig.service.FunctionService;
import com.demo.spring4.chapter01.javaconfig.service.impl.FunctionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
/**
 * @title <p>Java 配置类<p>
 * @desc 涉及到的注解 @Configuration | @Bean | @Scope
 * @author Panlibin2015
 * @date 2017-11-8
 */
@Configuration
public class BeanConfiguration {
    @Bean // 声明一个Bean,默认方法名为其BeanId
    public FunctionDao functionDao() {
        return new FunctionDao();
    }

    @Bean(name="functionDaoSingleton")
    @Scope("singleton")
    public FunctionDao functionDaoSingleton() {
        return new FunctionDao();
    }

    @Bean(name="functionDaoPrototype")
    @Scope("prototype")
    public FunctionDao functionDaoPrototype() {
        return new FunctionDao();
    }

    /**
     * 通过参数注入
     *
     * @param functionDao
     * @return
     */
    @Bean
    public FunctionService functionServiceByParam(FunctionDao functionDao) {
        FunctionServiceImpl functionService = new FunctionServiceImpl();
        functionService.setFunctionDao(functionDao);
        return functionService;
    }

    /**
     * 通过getFunctionDao()获取依赖对象
     *
     * @return
     */
    @Bean
    public FunctionService functionService() {
        FunctionServiceImpl functionService = new FunctionServiceImpl();
        functionService.setFunctionDao(functionDao());
        return functionService;
    }

    /**
     * 通过getFunctionDao()获取依赖对象
     *
     * @return
     */
    @Bean(name="functionServiceWithInitAndDestory",initMethod = "init",destroyMethod = "destroy")
    public FunctionService functionServiceInitAndDestory() {
        FunctionServiceImpl functionService = new FunctionServiceImpl();
        functionService.setFunctionDao(functionDao());
        return functionService;
    }
}
