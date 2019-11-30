package com.prueba.desarrollo;

import com.prueba.desarrollo.controller.IController;
import com.prueba.desarrollo.controller.MathExpresionController;
import com.prueba.desarrollo.facade.IEvaluateFacade;
import com.prueba.desarrollo.pojo.dto.ResponseDTO;
import com.prueba.desarrollo.pojo.request.MathExpresionRequest;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestController {

    @Test
    public void testController() throws Exception {
        String expresion = "1+8*2";
        String output = "OUTPUT";
        ResponseDTO responseDTO = initResponse(expresion,output);
        IEvaluateFacade evaluateFacade = mock(IEvaluateFacade.class);
        when(evaluateFacade.processExpresion(any())).thenReturn(responseDTO);

        IController controller = new MathExpresionController(evaluateFacade);
        MathExpresionRequest request = new MathExpresionRequest();
        request.setExp(expresion);

        ResponseEntity<ResponseDTO> response = controller.postMethod(request);

        assertNotNull(response);
        assertEquals(HttpStatus.OK.value(),response.getStatusCodeValue());
    }

    private ResponseDTO initResponse(String input,String output){
        return new ResponseDTO(input,output,10.00);
    }
}
