package com.example.mvchomework.controllers;

import com.example.mvchomework.dto.OperationDTO;
import com.example.mvchomework.dto.OperationsResponse;
import com.example.mvchomework.models.Operation;
import com.example.mvchomework.services.OperationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest")
public class OperationsRestController {
    private final ModelMapper modelMapper;
    private final OperationService operationService;

    @Autowired
    public OperationsRestController(ModelMapper modelMapper, OperationService operationService) {
        this.modelMapper = modelMapper;
        this.operationService = operationService;
    }

    @GetMapping("/operations")
    public OperationsResponse showAll() {
        OperationsResponse operationsResponse = new OperationsResponse(operationService.findAll().stream().map(this::convertToDTO).collect(Collectors.toList()));
        return operationsResponse;
    }

    private OperationDTO convertToDTO(Operation operation) {
        return modelMapper.map(operation, OperationDTO.class);
    }
}
