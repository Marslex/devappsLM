package com.prueba.desarrollo.exception;

import com.prueba.desarrollo.pojo.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HandlerException implements IHandlerException{
    @Override
    public ResponseEntity handlerException(Exception exception) {
        if(exception instanceof CustomException){
            return new ResponseEntity(new ErrorMessage(exception.getMessage()),((CustomException)exception).getStatus());
        }else {
            return new ResponseEntity(new ErrorMessage("Some error ocurred while processing the expression"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
