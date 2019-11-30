package com.prueba.desarrollo;

import org.junit.Test;

public class TestStringArray {
    @Test
    public void testArray(){
        String expresion = "1+8*2";
        char[] arrays  = expresion.toCharArray();
        String arrs = String.valueOf(arrays[0]);
        for (char aaa : arrays){

        }
    }
}
