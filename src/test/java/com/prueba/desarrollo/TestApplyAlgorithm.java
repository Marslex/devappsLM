package com.prueba.desarrollo;

import com.prueba.desarrollo.service.ApplyAlgorithm;
import com.prueba.desarrollo.service.IApplyAlgorithm;
import org.junit.Test;

public class TestApplyAlgorithm {
    @Test
    public void testApplyAlgorithm(){
        String expresion = "1+2.5/3*4";
        String output = "12.53/4*+";
        IApplyAlgorithm applyAlgorithm = new ApplyAlgorithm();

        //String generatedExpresion = applyAlgorithm.aplyAlgorithm()
    }
}
