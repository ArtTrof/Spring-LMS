package com.example.mvchomework.services;

import com.example.mvchomework.models.Balance;
import com.example.mvchomework.models.Operation;
import com.example.mvchomework.repositories.BalanceRepository;
import com.example.mvchomework.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OperationService {
    private final OperationRepository operationRepository;
    private final BalanceRepository balanceRepository;
    private final  BalanceService balanceService;

    @Autowired
    public OperationService(OperationRepository operationRepository, BalanceRepository balanceRepository, BalanceService balanceService) {
        this.operationRepository = operationRepository;
        this.balanceRepository = balanceRepository;
        this.balanceService = balanceService;
    }

    @Transactional
    public void save(Operation operation) {
       operation.setBalance(balanceService.findOneBalance(1));
        operationRepository.save(operation);
        Optional<Balance> newBalance;
        balanceRepository.findById(1).ifPresent(balance -> balance.setAmount(balance.getAmount() + operation.getAmount()));
    }
    public List<Operation> findAll(){
        return operationRepository.findAll();
    }
}
