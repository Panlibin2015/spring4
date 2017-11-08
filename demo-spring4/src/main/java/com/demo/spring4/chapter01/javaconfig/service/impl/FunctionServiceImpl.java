package com.demo.spring4.chapter01.javaconfig.service.impl;

import com.demo.spring4.chapter01.javaconfig.dao.FunctionDao;
import com.demo.spring4.chapter01.javaconfig.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Panlibin2015
 * @title <p>测试服务实现类<p>
 * @date 2017-11-8
 */
public class FunctionServiceImpl implements FunctionService {
    @Autowired
    private FunctionDao functionDao;

    @Override
    public String sayHello(String word) {
        return functionDao.sayHello(word);
    }

    @Override
    public void destroy() {
        System.out.println(String.format("Class:%s,Method:%s", new String[]{this.getClass() + "", "destory()"}));
    }

    @Override
    public void init() {
        System.out.println(String.format("Class:%s,Method:%s", new String[]{this.getClass() + "", "init()"}));
    }

    public FunctionDao getFunctionDao() {
        return functionDao;
    }

    public void setFunctionDao(FunctionDao functionDao) {
        this.functionDao = functionDao;
    }
}
