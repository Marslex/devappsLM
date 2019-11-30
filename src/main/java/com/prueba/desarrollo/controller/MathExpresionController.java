package com.prueba.desarrollo.controller;

import com.prueba.desarrollo.exception.CustomException;
import com.prueba.desarrollo.exception.IHandlerException;
import com.prueba.desarrollo.facade.IEvaluateFacade;
import com.prueba.desarrollo.pojo.dto.ErrorMessage;
import com.prueba.desarrollo.pojo.dto.ResponseDTO;
import com.prueba.desarrollo.pojo.request.MathExpresionRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathExpresionController implements IController<MathExpresionRequest> {
    IEvaluateFacade evaluateFacade;
    IHandlerException handlerException;

    public MathExpresionController(IEvaluateFacade evaluateFacade, IHandlerException handlerException) {
        this.evaluateFacade = evaluateFacade;
        this.handlerException = handlerException;
    }

    @Override
    @PostMapping("/evaluate")
    public ResponseEntity postMethod(@RequestBody MathExpresionRequest request) {
        try {
            return new ResponseEntity<ResponseDTO>(evaluateFacade.processExpresion(request),HttpStatus.OK);
        } catch (Exception e) {
            return handlerException.handlerException(e);
        }
    }
}
