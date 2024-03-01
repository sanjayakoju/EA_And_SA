package com.example.programmingtest3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    ResourceBundleMessageSource messageSource;

    @GetMapping("/hello")
    public String getHello() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
