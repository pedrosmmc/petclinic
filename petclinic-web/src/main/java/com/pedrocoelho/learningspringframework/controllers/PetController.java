package com.pedrocoelho.learningspringframework.controllers;

import com.pedrocoelho.learningspringframework.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping("/pets")
    public String petsList(Model model) {
        model.addAttribute("pets", petService.findAll());

        return "pets/index";
    }
}
