package com.olindena.online.chat.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthApi {

    @GetMapping("health")
    public String healthCheck() {
        return "OK";
    }


}
