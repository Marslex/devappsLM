package com.prueba.desarrollo.builder;

import com.prueba.desarrollo.pojo.dto.ResponseDTO;

public interface IResponseDTOBuilder {
    public IResponseDTOBuilder withInfix(String infix);
    public IResponseDTOBuilder withPostfix(String postfix);
    public IResponseDTOBuilder withResult(double result);
    public ResponseDTO build();
}
