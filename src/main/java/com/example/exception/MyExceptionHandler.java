package com.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerMethodExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zhangkh on 2017/6/12.
 */
@ControllerAdvice
public class MyExceptionHandler extends AbstractHandlerMethodExceptionResolver {
    private final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
    @Override
    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest httpServletRequest,
                                                           HttpServletResponse httpServletResponse,
                                                           HandlerMethod handlerMethod, Exception ex) {

        logger.debug("==========================MyExceptionHandler");
        logger.debug(ex.getMessage());
      /*  使用response返回    */
        httpServletResponse.setStatus(HttpStatus.OK.value()); //设置状态码
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        httpServletResponse.setCharacterEncoding("UTF-8"); //避免乱码
        httpServletResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            httpServletResponse.getWriter().write("{\"success\":false,\"msg\":\"" + ex.getMessage() + "\"}");
        } catch (IOException e) {
            //log.error("与客户端通讯异常:"+ e.getMessage(), e);
        }

        return new ModelAndView();
    }
}
