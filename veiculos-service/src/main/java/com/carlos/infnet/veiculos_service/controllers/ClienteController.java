package com.carlos.infnet.veiculos_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.infnet.veiculos_service.models.Veiculo;
import com.carlos.infnet.veiculos_service.services.ClienteService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{ano}")
    public Flux<Veiculo> getVeiculoByAno(@PathVariable Integer ano) {
        return clienteService.getVeiculoByAno(ano);
    }
}
