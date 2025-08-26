package com.example.calculator.model;

public class DTO {
    private String inputA;
    private String inputB;
    private String result;

    public DTO() {}

    // inputA
    public String getInputA() {
        return inputA;
    }
    public void setInputA(String inputA) {
        this.inputA = inputA;
    }

    // inputB
    public String getInputB() {
        return inputB;
    }
    public void setInputB(String inputB) {
        this.inputB = inputB;
    }

    // result
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}