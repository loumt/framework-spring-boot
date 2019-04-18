package com.boot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("MyHttpSessionListener")
public class MyHttpSessionListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("自定义监听器:ServletContextListener->contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
