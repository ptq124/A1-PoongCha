package com.poongcha.car.presentation;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionControllerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public void invalidRequest(HttpServletResponse response) {
        response.setStatus(HttpStatus.NOT_FOUND.value());
    }
}
