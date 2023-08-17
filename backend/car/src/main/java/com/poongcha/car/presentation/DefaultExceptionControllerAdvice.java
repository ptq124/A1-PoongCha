package com.poongcha.car.presentation;

import java.sql.SQLIntegrityConstraintViolationException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionControllerAdvice {
    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public void badRequest(HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
    }
}
