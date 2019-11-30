package com.prueba.desarrollo.builder;

import com.prueba.desarrollo.pojo.dto.ResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ResponseDTOBuider implements IResponseDTOBuilder {
    private String infix;
    private String postfix;
    private double result;

    @Override
    public IResponseDTOBuilder withInfix(String infix) {
        this.infix = infix;
        return this;
    }

    @Override
    public IResponseDTOBuilder withPostfix(String postfix) {
        this.postfix = postfix;
        return this;
    }

    @Override
    public IResponseDTOBuilder withResult(double result) {
        this.result = result;
        return this;
    }

    @Override
    public ResponseDTO build() {
        return new ResponseDTO(infix,postfix,result);
    }
}
