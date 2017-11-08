package com.demo.spring4.chapter01.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.demo.spring4.chapter01.aop")
@EnableAspectJAutoProxy
public class AopConifg {

}
