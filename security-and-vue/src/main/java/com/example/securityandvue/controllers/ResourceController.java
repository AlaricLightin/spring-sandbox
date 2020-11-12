package com.example.securityandvue.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class ResourceController {
    @GetMapping("/resource")
    public Map<String, Object> home(){
        return Map.of(
                "id", UUID.randomUUID().toString(),
                "content", "Hello world"
        );
    }
}
