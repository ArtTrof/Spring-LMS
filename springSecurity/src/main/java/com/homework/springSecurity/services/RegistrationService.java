package com.homework.springSecurity.services;

import com.homework.springSecurity.models.Visitor;
import com.homework.springSecurity.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class RegistrationService {
    private final VisitorRepository visitorRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(VisitorRepository visitorRepository, PasswordEncoder passwordEncoder) {
        this.visitorRepository = visitorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Visitor visitor) {
        String encodedPassword = passwordEncoder.encode(visitor.getPassword());
        visitor.setPassword(encodedPassword);
        visitor.setCreatedAt(new Date(System.currentTimeMillis()));
        visitor.setRole("ROLE_USER");
        visitorRepository.save(visitor);
    }
}
