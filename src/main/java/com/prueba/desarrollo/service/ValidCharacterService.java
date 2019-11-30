package com.prueba.desarrollo.service;

import com.prueba.desarrollo.pojo.model.ValidCharacter;
import com.prueba.desarrollo.pojo.repository.ValidCharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidCharacterService {
    private ValidCharacterRepository validCharacterRepository;

    public ValidCharacterService(ValidCharacterRepository validCharacterRepository) {
        this.validCharacterRepository = validCharacterRepository;
    }

    public List<ValidCharacter> getAll(){
        return validCharacterRepository.findAll();
    }
}
