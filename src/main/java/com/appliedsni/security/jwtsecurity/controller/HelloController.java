package com.appliedsni.security.jwtsecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/secure")
public class HelloController {

    @GetMapping(value="hello")
    public String hello() {
        return "Hello World";
    }
}
