package com.pedrocoelho.learningspringframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetController {
    @RequestMapping("/pets")
    public String petsList() {
        return "pets/index";
    }
}
