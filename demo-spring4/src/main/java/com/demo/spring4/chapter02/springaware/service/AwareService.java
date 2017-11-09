package com.demo.spring4.chapter02.springaware.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {//实现BeanNameAware、ResourceLoaderAware接口，获得Bean名称和资源加载服务
    private String beanName;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {// 实现ResourceLoaderAware需重写setResourceLoader
        this.loader = resourceLoader;
    }

    public void outputResoult() {
        System.out.println("Bean的名称为：" + beanName);
        Resource resource = loader.getResource("classpath:com/demo/spring4/chapter02/springaware/test.txt");
        try {
            System.out.println("ResourceLoader 加载的文件内容为：" + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
