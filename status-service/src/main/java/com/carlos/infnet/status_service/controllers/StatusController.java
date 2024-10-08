package com.carlos.infnet.status_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @Autowired
    private Environment environment;
    
    @GetMapping
    public String getStatus() {
        String port = environment.getProperty("local.server.port");
        return "Service subiu e está ativo! Rodando na porta: " + port;
    }
}
