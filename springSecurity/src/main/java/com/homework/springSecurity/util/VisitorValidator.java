package com.homework.springSecurity.util;

import com.homework.springSecurity.models.Visitor;
import com.homework.springSecurity.services.VisitorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class VisitorValidator implements Validator {
    private final VisitorDetailsService visitorDetailsService;

    @Autowired
    public VisitorValidator(VisitorDetailsService visitorDetailsService) {
        this.visitorDetailsService = visitorDetailsService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Visitor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Visitor visitor = (Visitor) target;
        try {
            visitorDetailsService.loadUserByUsername(visitor.getUsername());
        } catch (UsernameNotFoundException e) {
            return;
        }
        errors.rejectValue("username", "","user with such username already exists" );
    }
}
