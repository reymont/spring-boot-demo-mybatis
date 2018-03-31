package com.example.spring.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Zhangkh on 2017/3/29.
 */
@WebServlet(urlPatterns = "/test/a")
public class ServletA extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(ServletA.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            logger.debug("In ServletA class");
//            Object a = req.getAttribute("x-auth-token");

            HttpSession session = req.getSession();
            Object value = session.getAttribute("x-auth-token");
            resp.getWriter().write("ServletA");
            logger.debug("session id:"+ req.getHeader("x-auth-token"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
