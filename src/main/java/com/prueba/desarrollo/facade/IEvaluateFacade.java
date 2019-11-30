package com.prueba.desarrollo.facade;

import com.prueba.desarrollo.pojo.dto.ResponseDTO;
import com.prueba.desarrollo.pojo.request.MathExpresionRequest;

public interface IEvaluateFacade {
    public ResponseDTO processExpresion(MathExpresionRequest request) throws Exception;
}
