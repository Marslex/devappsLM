package com.prueba.desarrollo;

import com.prueba.desarrollo.builder.IResponseDTOBuilder;
import com.prueba.desarrollo.builder.ResponseDTOBuider;
import com.prueba.desarrollo.facade.EvaluateFacade;
import com.prueba.desarrollo.facade.IEvaluateFacade;
import com.prueba.desarrollo.pojo.dto.ResponseDTO;
import com.prueba.desarrollo.pojo.repository.OperatorRepository;
import com.prueba.desarrollo.pojo.repository.ValidCharacterRepository;
import com.prueba.desarrollo.pojo.request.MathExpresionRequest;
import com.prueba.desarrollo.service.IApplyAlgorithm;
import com.prueba.desarrollo.service.OperatorService;
import com.prueba.desarrollo.service.ValidCharacterService;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestEvaluateFacade {

    @Test
    public void testEvaluateFacade() throws Exception {
        String expresion = "1+8*2";
        String output = "OUTPUT";
        MathExpresionRequest mathExpresionRequest = initRequest(expresion);
        OperatorRepository operatorRepository = mock(OperatorRepository.class);
        ValidCharacterRepository validCharacterRepository = mock(ValidCharacterRepository.class);
        IApplyAlgorithm applyAlgorithm = mock(IApplyAlgorithm.class);

        IResponseDTOBuilder responseDTOBuilder = new ResponseDTOBuider();
        OperatorService operatorService = new OperatorService(operatorRepository);
        ValidCharacterService validCharacterService = new ValidCharacterService(validCharacterRepository);
        when(operatorRepository.findAll()).thenReturn(TestOperatorService.initList());
        when(validCharacterRepository.findAll()).thenReturn(TestValidCharacterService.initList());

        when(applyAlgorithm.aplyAlgorithm(any(),any(),any())).thenReturn(output);

        IEvaluateFacade evaluateFacade = new EvaluateFacade(applyAlgorithm,responseDTOBuilder,operatorService,validCharacterService);

        ResponseDTO responseDTO = evaluateFacade.processExpresion(mathExpresionRequest);

        assertEquals(expresion,responseDTO.getInfix());
        assertEquals(output,responseDTO.getPostfix());
    }

    private MathExpresionRequest initRequest(String input){
        MathExpresionRequest mathExpresionRequest = new MathExpresionRequest();
        mathExpresionRequest.setExp(input);
        return mathExpresionRequest;
    }


}
