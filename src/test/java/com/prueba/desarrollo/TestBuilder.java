package com.prueba.desarrollo;

import com.prueba.desarrollo.builder.IResponseDTOBuilder;
import com.prueba.desarrollo.builder.ResponseDTOBuider;
import com.prueba.desarrollo.pojo.dto.ResponseDTO;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBuilder {

    @Test
    public void testResponseDTOBuilder(){
        String infix = "infix";
        String postfix = "postfix";
        double result = 20.0;
        IResponseDTOBuilder responseDTOBuilder = new ResponseDTOBuider();

        ResponseDTO responseDTO = responseDTOBuilder
                .withInfix(infix)
                .withPostfix(postfix)
                .withResult(result)
                .build();
        assertEquals(infix, responseDTO.getInfix());
        assertEquals(postfix, responseDTO.getPostfix());
        assertTrue(result==responseDTO.getResult());
    }
}
