package com.pedrocoelho.learningspringframework.controllers;

import com.pedrocoelho.learningspringframework.model.Owner;
import com.pedrocoelho.learningspringframework.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setDisallowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping()
    public String getOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/{id}")
    public String getOwnerById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("owner", ownerService.findById(id));
        return "owners/single";
    }

    @RequestMapping("/find")
    public String findOwnersByFirstNameOrLastName(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName, Model model) {
        if (firstName != null & lastName != null) {
            System.out.println(" >>> by firstname and lastname");
            Set<Owner> filteredOwners = ownerService.findAllByFirstName(firstName).stream().filter(owner -> owner.getLastName().equals(lastName)).collect(Collectors.toSet());
            model.addAttribute("owners", filteredOwners);
        }

        if(lastName == null) {
            System.out.println(" >>> by firstname");
            model.addAttribute("owners", ownerService.findAllByFirstName(firstName));
        }

        if(firstName == null) { // condition not needed
            System.out.println(" >>> by lastname");
            model.addAttribute("owners", ownerService.findAllByLastName(lastName));
        }

        System.out.println(" >>> all");
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }
}
