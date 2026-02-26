package com.joan.orchard_backend_java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    
    @GetMapping("/api/health")
    public String healt() {
        return "Hello, OK!";
    }
    
}
