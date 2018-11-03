package com.ypxx.manage.common.filter;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xuwei on 2018/10/12.
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(UnauthorizedException e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex", e);
        mv.setViewName("error");
        return mv;
    }
}
