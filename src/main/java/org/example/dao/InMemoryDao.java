package org.example.dao;

import org.example.entity.Operation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class InMemoryDao implements OperationDao{
    private static final List<Operation> operations = new ArrayList<>();

    @Override
    public void save(Operation operation) {
        operations.add(operation);
    }

    @Override
    public List<Operation> getAll() {
        return new ArrayList<>(operations);
    }

}
