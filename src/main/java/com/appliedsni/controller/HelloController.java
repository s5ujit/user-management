package com.appliedsni.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/secure")
public class HelloController {

    @GetMapping(value="hello")
    public @ResponseBody  String hello() {
        return "Hello World";
    }
}
