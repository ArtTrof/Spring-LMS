package com.homework.springSecurity.controllers;

import com.homework.springSecurity.models.Visitor;
import com.homework.springSecurity.services.RegistrationService;
import com.homework.springSecurity.util.VisitorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final VisitorValidator visitorValidator;
    private final RegistrationService registrationService;

    @Autowired
    public AuthController(VisitorValidator visitorValidator, RegistrationService registrationService) {
        this.visitorValidator = visitorValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("visitor") Visitor visitor) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("visitor") @Valid Visitor visitor, BindingResult bindingResult) {
        visitorValidator.validate(visitor,bindingResult);
        if (bindingResult.hasErrors())
            return "auth/registration";
        registrationService.register(visitor);
            return "redirect:/auth/login";
    }
}
