package com.carlos.infnet.veiculos_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.carlos.infnet.veiculos_service.models.Veiculo;
import com.carlos.infnet.veiculos_service.services.VeiculoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public Flux<Veiculo> listar() {
        return veiculoService.listar();
    }

    @GetMapping("/{id}")
    public Mono<Veiculo> buscarPorId(@PathVariable Long id) {
        return veiculoService.buscarPorId(id);
    }

    @GetMapping("/ano/{ano}")
    public Flux<Veiculo> buscarPorAno(@PathVariable Integer ano) {
        return veiculoService.buscarPorAno(ano);
    }

    @PostMapping
    public Mono<Veiculo> adicionar(@RequestBody Veiculo veiculo) {
        return veiculoService.adicionar(veiculo);
    }

    @PutMapping("/{id}")
    public Mono<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        return veiculoService.atualizar(id, veiculo);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> remover(@PathVariable Long id) {
        return veiculoService.remover(id);
    }
}
