package com.prueba.desarrollo.controller;

import org.springframework.http.ResponseEntity;

public interface IController<T> {
    public ResponseEntity postMethod(T body) throws Exception;
}
