package com.demo.spring4.chapter02.conditional;

import com.demo.spring4.chapter02.conditional.match.LinuxCondition;
import com.demo.spring4.chapter02.conditional.match.WindowsCondition;
import com.demo.spring4.chapter02.conditional.service.ListService;
import com.demo.spring4.chapter02.conditional.service.impl.LinuxListService;
import com.demo.spring4.chapter02.conditional.service.impl.WindowsListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsListService() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService() {
        return new LinuxListService();
    }

}
