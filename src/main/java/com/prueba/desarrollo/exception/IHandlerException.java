package com.prueba.desarrollo.exception;

import org.springframework.http.ResponseEntity;

public interface IHandlerException {
    public ResponseEntity handlerException(Exception exception);
}
