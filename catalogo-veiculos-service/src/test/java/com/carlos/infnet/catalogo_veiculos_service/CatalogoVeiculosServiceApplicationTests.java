package com.carlos.infnet.catalogo_veiculos_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.carlos.infnet.catalogo_veiculos_service.models.Veiculo;
import com.carlos.infnet.catalogo_veiculos_service.repositories.VeiculoRepository;

@SpringBootTest
@AutoConfigureMockMvc
class CatalogoVeiculosServiceApplicationTests {

	 @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Test
    public void testListarVeiculos() throws Exception {
        mockMvc.perform(get("/veiculos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testAdicionarVeiculo() throws Exception {
        String novoVeiculoJson = "{\"marca\":\"Toyota\",\"modelo\":\"Corolla\",\"ano\":2022}";
        mockMvc.perform(post("/veiculos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(novoVeiculoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.marca").value("Toyota"));
    }

    @Test
    public void testAtualizarVeiculo() throws Exception {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("Ford");
        veiculo.setModelo("Focus");
        veiculo.setAno(2020);
        veiculoRepository.save(veiculo);

        String veiculoAtualizadoJson = "{\"marca\":\"Ford\",\"modelo\":\"Fusion\",\"ano\":2021}";
        mockMvc.perform(put("/veiculos/" + veiculo.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(veiculoAtualizadoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modelo").value("Fusion"));
    }

    @Test
    public void testRemoverVeiculo() throws Exception {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("Honda");
        veiculo.setModelo("Civic");
        veiculo.setAno(2019);
        veiculoRepository.save(veiculo);

        mockMvc.perform(delete("/veiculos/" + veiculo.getId()))
                .andExpect(status().isOk());
    }

}
