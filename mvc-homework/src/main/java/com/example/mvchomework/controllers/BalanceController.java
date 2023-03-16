package com.example.mvchomework.controllers;

import com.example.mvchomework.models.Operation;
import com.example.mvchomework.services.BalanceService;
import com.example.mvchomework.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.GeneratedValue;

@Controller
public class BalanceController {
    private final BalanceService balanceService;
    private final OperationService operationService;

    @Autowired
    public BalanceController(BalanceService balanceService, OperationService operationService) {
        this.balanceService = balanceService;
        this.operationService = operationService;
    }

    @GetMapping("")
    public String balance(Model model) {
        model.addAttribute("balance", balanceService.findOneBalance(1));
        model.addAttribute("operations", balanceService.findOperationsByBalanceId(1));
        return "balance";
    }

    @GetMapping("/transaction")
    public String operation(@ModelAttribute("operation") Operation operation) {
        return "operation";
    }
    @PostMapping("/transaction")
    public String newOperation(@ModelAttribute("operation")Operation operation){
        operationService.save(operation);
        return "redirect:/";
    }
}
