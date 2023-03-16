package com.example.mvchomework.repositories;

import com.example.mvchomework.models.Balance;
import com.example.mvchomework.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BalanceRepository  extends JpaRepository<Balance,Integer> {

}
