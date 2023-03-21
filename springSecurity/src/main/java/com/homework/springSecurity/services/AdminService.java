package com.homework.springSecurity.services;

import com.homework.springSecurity.models.Visitor;
import com.homework.springSecurity.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AdminService {
    private final VisitorRepository visitorRepository;

    @Autowired
    public AdminService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public List<Visitor> findAll() {
        return visitorRepository.findAll();
    }

    public Visitor findOne(int id) {
        Optional<Visitor> visitor = visitorRepository.findById(id);
        return visitor.orElse(null);
    }
    @Transactional
    public void updateVisitor(int id, Visitor visitor) {
        visitorRepository.save(visitor);
    }
}
