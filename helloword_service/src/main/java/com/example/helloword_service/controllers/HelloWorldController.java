package com.example.helloword_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(value="/hello")
    public String sayHello(){
        return "Hello World!";
    }
}
