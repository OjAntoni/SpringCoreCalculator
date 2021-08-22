package org.example.service;

import org.example.dao.InMemoryDao;
import org.example.dao.OperationDao;
import org.example.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationService {
    private OperationDao operationDao;

    public Operation createOperation(long num1, long num2, String operation){
        double result = calculateResult(num1, num2, operation);
        return new Operation(num1, num2, operation, result);
    }

    private double calculateResult(long num1, long num2, String operation){
        return switch (operation){
            case "+" -> num1+num2;
            case "-" -> num1-num2;
            case "*" -> num1*num2;
            case "/" -> (double)num1/num2;
            default -> 0;
        };
    }

    public void save(Operation operation){
        if (operation==null) return;
        operationDao.save(operation);
    }

    public List<Operation> getOperations(){
        return operationDao.getAll();
    }

    @Autowired
    public void setOperationDao(@Qualifier("inMemoryDao") OperationDao operationDao) {
        this.operationDao = operationDao;
    }
}
