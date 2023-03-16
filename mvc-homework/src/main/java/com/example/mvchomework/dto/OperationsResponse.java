package com.example.mvchomework.dto;

import com.example.mvchomework.models.Operation;

import java.util.List;

public class OperationsResponse {
    private List<OperationDTO> operations;

    public OperationsResponse(List<OperationDTO> operations) {
        this.operations = operations;
    }

    public List<OperationDTO> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationDTO> operations) {
        this.operations = operations;
    }
}
