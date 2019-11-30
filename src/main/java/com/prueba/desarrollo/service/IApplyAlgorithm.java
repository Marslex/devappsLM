package com.prueba.desarrollo.service;

import java.util.List;
import java.util.Map;

public interface IApplyAlgorithm {
    public String aplyAlgorithm(String input, Map<String,Integer> operators, List<String> characters) throws Exception;
    public double result(String expresion);
}
