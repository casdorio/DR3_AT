package com.carlos.infnet.veiculos_service.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.carlos.infnet.veiculos_service.models.Veiculo;

import reactor.core.publisher.Flux;

@Repository
public interface VeiculoRepository extends ReactiveCrudRepository<Veiculo, Long> {
    Flux<Veiculo> findByAno(Integer ano);
}
