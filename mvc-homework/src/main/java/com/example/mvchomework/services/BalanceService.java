package com.example.mvchomework.services;

import com.example.mvchomework.models.Balance;
import com.example.mvchomework.models.Operation;
import com.example.mvchomework.repositories.BalanceRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BalanceService {
    private final BalanceRepository balanceRepository;

    @Autowired
    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public Balance findOneBalance(int id) {
        Optional<Balance>  balance= balanceRepository.findById(id);
        return balance.orElse(null);
    }
    public List<Operation> findOperationsByBalanceId(int id){
        Optional<Balance>  balance= balanceRepository.findById(id);
        Hibernate.initialize(balance.get().getOperations());
        return balance.get().getOperations();
    }

}
