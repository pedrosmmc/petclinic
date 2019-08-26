package com.pedrocoelho.learningspringframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping({"", "/", "/index", "index.html"})
    public String index() {
        return "index";
    }
}
