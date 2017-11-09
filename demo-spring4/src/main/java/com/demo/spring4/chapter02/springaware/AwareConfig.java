package com.demo.spring4.chapter02.springaware;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.demo.spring4.chapter02.springaware.service")
public class AwareConfig {
}
