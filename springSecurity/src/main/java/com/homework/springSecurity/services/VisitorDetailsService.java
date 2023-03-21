package com.homework.springSecurity.services;

import com.homework.springSecurity.models.Visitor;
import com.homework.springSecurity.repositories.VisitorRepository;
import com.homework.springSecurity.security.VisitorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitorDetailsService implements UserDetailsService {
    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorDetailsService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Visitor> visitor = visitorRepository.findByUsername(username);
        if (visitor.isEmpty())
            throw new UsernameNotFoundException("visitor not found");

        return new VisitorDetails(visitor.get());
    }
}
