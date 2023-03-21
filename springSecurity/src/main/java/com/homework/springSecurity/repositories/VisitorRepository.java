package com.homework.springSecurity.repositories;

import com.homework.springSecurity.models.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Integer> {
    Optional<Visitor>findByUsername(String username);
}
