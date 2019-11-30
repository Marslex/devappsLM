package com.prueba.desarrollo.facade;

import com.prueba.desarrollo.builder.IResponseDTOBuilder;
import com.prueba.desarrollo.pojo.dto.ResponseDTO;
import com.prueba.desarrollo.pojo.model.Operator;
import com.prueba.desarrollo.pojo.model.ValidCharacter;
import com.prueba.desarrollo.pojo.request.MathExpresionRequest;
import com.prueba.desarrollo.service.IApplyAlgorithm;
import com.prueba.desarrollo.service.OperatorService;
import com.prueba.desarrollo.service.ValidCharacterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("evaluateFacade")
public class EvaluateFacade implements IEvaluateFacade{
    private IApplyAlgorithm applyAlgorithm;
    private IResponseDTOBuilder responseDTOBuilder;
    private OperatorService operatorService;
    private ValidCharacterService validCharacterService;

    public EvaluateFacade(IApplyAlgorithm applyAlgorithm, IResponseDTOBuilder responseDTOBuilder, OperatorService operatorService, ValidCharacterService validCharacterService) {
        this.applyAlgorithm = applyAlgorithm;
        this.responseDTOBuilder = responseDTOBuilder;
        this.operatorService = operatorService;
        this.validCharacterService = validCharacterService;
    }

    @Override
    public ResponseDTO processExpresion(MathExpresionRequest request) throws Exception {
        List<Operator> operators = operatorService.getAll();
        List<ValidCharacter> characters = validCharacterService.getAll();

        Map<String,Integer> operatorCharacters = new HashMap<>();
        operators.forEach(operator -> operatorCharacters.put(operator.getCharacter(),operator.getPrecedence()));

        List<String> validCharactes = new ArrayList<>();
        characters.forEach(character -> validCharactes.add(character.getCharacter()));
        return responseDTOBuilder
                .withInfix(request.getExp())
                .withPostfix(applyAlgorithm.aplyAlgorithm(request.getExp(),operatorCharacters,validCharactes))
                .withResult(applyAlgorithm.result(request.getExp()))
                .build();
    }
}
