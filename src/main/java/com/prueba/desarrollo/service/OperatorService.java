package com.prueba.desarrollo.service;

import com.prueba.desarrollo.pojo.model.Operator;
import com.prueba.desarrollo.pojo.repository.OperatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService {
    private OperatorRepository operatorRepository;

    public OperatorService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public List<Operator> getAll(){
        return operatorRepository.findAll();
    }
}
