package com.homework.springSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitorController {
    @GetMapping("/main")
    public String main(){
        return "/main";
    }
}
