package com.carlos.infnet.catalogo_veiculos_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.infnet.catalogo_veiculos_service.models.Veiculo;
import com.carlos.infnet.catalogo_veiculos_service.repositories.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    public Veiculo adicionar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo atualizar(Long id, Veiculo veiculoAtualizado) {
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow();
        veiculo.setMarca(veiculoAtualizado.getMarca());
        veiculo.setModelo(veiculoAtualizado.getModelo());
        veiculo.setAno(veiculoAtualizado.getAno());
        return veiculoRepository.save(veiculo);
    }

    public void remover(Long id) {
        veiculoRepository.deleteById(id);
    }
}