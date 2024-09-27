package com.carlos.infnet.veiculos_service.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.carlos.infnet.veiculos_service.models.Veiculo;

import reactor.core.publisher.Flux;

@Service
public class ClienteService {

     private final WebClient webClient;

     public ClienteService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/api/v1/").build();
    }

    public Flux<Veiculo> getVeiculoByAno(Integer ano) {
    return this.webClient.get()
            .uri("veiculos/ano/{ano}", ano)
            .retrieve()
            .bodyToFlux(Veiculo.class)
            .onErrorResume(error -> Flux.error(new RuntimeException("Erro ao buscar os veículos pelo ano", error)));
}
}
