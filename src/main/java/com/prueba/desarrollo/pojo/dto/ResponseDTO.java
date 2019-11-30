package com.prueba.desarrollo.pojo.dto;

public class ResponseDTO {
    private String infix;
    private String postfix;
    private double result;

    public ResponseDTO(String infix, String postfix, double result) {
        this.infix = infix;
        this.postfix = postfix;
        this.result = result;
    }

    public String getInfix() {
        return infix;
    }

    public String getPostfix() {
        return postfix;
    }

    public double getResult() {
        return result;
    }

    public void setInfix(String infix) {
        this.infix = infix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
