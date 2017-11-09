package com.demo.spring4.chapter02.conditional.service.impl;

import com.demo.spring4.chapter02.conditional.service.ListService;

public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
