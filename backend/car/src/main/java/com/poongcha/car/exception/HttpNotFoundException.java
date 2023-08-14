package com.poongcha.car.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HttpNotFoundException extends RuntimeException {
    public HttpNotFoundException(final String message) {
        super(message);
    }
}
