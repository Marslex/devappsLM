package com.prueba.desarrollo;

import com.prueba.desarrollo.exception.CustomException;
import com.prueba.desarrollo.exception.HandlerException;
import com.prueba.desarrollo.exception.IHandlerException;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.*;

public class TestHandlerException {

    @Test
    public void testHandlerExceptionBadRequest(){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = "messageException";
        CustomException customException = new CustomException(status,message);


        IHandlerException handlerException = new HandlerException();

        ResponseEntity responseEntity = handlerException.handlerException(customException);

        assertEquals(status.value(),responseEntity.getStatusCodeValue());
    }

    @Test
    public void testHandlerExceptionGeneral(){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = "messageException";
        Exception customException = new Exception(message);


        IHandlerException handlerException = new HandlerException();

        ResponseEntity responseEntity = handlerException.handlerException(customException);

        assertEquals(status.value(),responseEntity.getStatusCodeValue());
    }
}
