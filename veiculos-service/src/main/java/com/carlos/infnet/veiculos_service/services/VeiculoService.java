package com.carlos.infnet.veiculos_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.infnet.veiculos_service.models.Veiculo;
import com.carlos.infnet.veiculos_service.repositories.VeiculoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Flux<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    public Mono<Veiculo> buscarPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public Flux<Veiculo> buscarPorAno(Integer ano) {
        return veiculoRepository.findByAno(ano);
    }

    public Mono<Veiculo> adicionar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Mono<Veiculo> atualizar(Long id, Veiculo veiculoAtualizado) {
        return veiculoRepository.findById(id)
        .flatMap(veiculos -> {
            veiculos.setMarca(veiculoAtualizado.getMarca());
            veiculos.setModelo(veiculoAtualizado.getModelo());
            veiculos.setAno(veiculoAtualizado.getAno());
            return veiculoRepository.save(veiculos);
        });
    }

    public Mono<Void> remover(Long id) {
        return veiculoRepository.deleteById(id);
    }
}