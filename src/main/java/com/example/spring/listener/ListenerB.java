package com.example.spring.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Zhangkh on 2017/3/30.
 */
@WebListener
public class ListenerB implements ServletContextListener {
    private final Logger logger = LoggerFactory.getLogger(ListenerB.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("In ListenerB");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
