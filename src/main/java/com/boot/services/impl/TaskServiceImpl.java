package com.boot.services.impl;

import com.boot.services.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public void executorTask1(Integer i) {
        System.out.println("执行任务1： " + i);
    }

    @Override
    public void executorTask2(Integer i) {
        System.out.println("执行任务2： " + i);
    }
}
