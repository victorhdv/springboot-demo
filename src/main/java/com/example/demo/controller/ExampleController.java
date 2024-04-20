package com.example.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/exemplo")
public class ExampleController {

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String hello(@PathVariable String name) {
        return "Hello " + name;
    }
}
