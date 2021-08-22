package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class Operation {

    private long num1;
    private long num2;
    private String operationSign;
    private double result;


    public static String[] getOperations(){
        return new String[]{"+","-","*","/"};
    }

    @Override
    public String toString() {
        return String.format("%d %s %d = %.2f", num1, operationSign, num2, result);
    }
}
