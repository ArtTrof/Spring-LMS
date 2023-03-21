package com.homework.springSecurity.controllers;

import com.homework.springSecurity.models.Visitor;
import com.homework.springSecurity.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("visitors", adminService.findAll());
        return "admin/users";
    }

    @GetMapping("/users/{visitor}")
    public String showUser(@PathVariable("visitor") Visitor visitor, Model model) {
        model.addAttribute("visitor", adminService.findOne(visitor.getId()));
        return "admin/showUser";
    }

    @GetMapping("/users/{visitor}/edit")
    public String editPage(Model model, @PathVariable("visitor") Visitor visitor) {
        model.addAttribute("visitor", adminService.findOne(visitor.getId()));
        return "admin/edit";
    }

    @PatchMapping("/update/{visitor}")
    public String update(@ModelAttribute("visitor") @Valid Visitor visitor,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "admin/edit";
        adminService.updateVisitor(visitor.getId(), visitor);
        return "redirect:/admin/users";
    }
}
