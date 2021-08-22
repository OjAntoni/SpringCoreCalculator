package org.example.dao;

import org.example.entity.Operation;

import java.util.List;

public interface OperationDao {
    public void save(Operation operation);
    public List<Operation> getAll();
}
