package com.genrs.webdataservice.controller;

import org.hibernate.annotations.GeneratorType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityCheck {

    @GetMapping(value = "/")
    public boolean test() {
        return true;
    }
}
