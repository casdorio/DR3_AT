package com.carlos.infnet.catalogo_veiculos_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.carlos.infnet.catalogo_veiculos_service.models.Veiculo;
import com.carlos.infnet.catalogo_veiculos_service.services.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> listar() {
        return veiculoService.listar();
    }

    @PostMapping
    public Veiculo adicionar(@RequestBody Veiculo veiculo) {
        return veiculoService.adicionar(veiculo);
    }

    @PutMapping("/{id}")
    public Veiculo atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        return veiculoService.atualizar(id, veiculo);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        veiculoService.remover(id);
    }
}
