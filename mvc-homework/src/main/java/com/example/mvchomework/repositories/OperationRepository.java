package com.example.mvchomework.repositories;

import com.example.mvchomework.models.Balance;
import com.example.mvchomework.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Integer> {
}
