package com.example.helloWorld.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class HelloWorldController {
    @GetMapping("/words")
    public String getWords() {
        return "Hello World";
    }
}
