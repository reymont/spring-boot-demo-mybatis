package com.example.spring.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zhangkh on 2017/3/29.
 */
@WebServlet(urlPatterns = "/test/b")
public class ServletB  extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(ServletB.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            logger.debug("In ServletB class");
            resp.getWriter().write("ServletB");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
