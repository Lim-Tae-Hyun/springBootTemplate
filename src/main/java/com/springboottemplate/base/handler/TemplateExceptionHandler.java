package com.springboottemplate.base.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class TemplateExceptionHandler {

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public void defaultExceptionHandler(
            HttpServletRequest request,
            HttpServletResponse reponse,
            Exception e) {
        log.error("Unchecked Exception Occur");
    }
}
