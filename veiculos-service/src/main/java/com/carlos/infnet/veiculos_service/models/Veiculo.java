package com.carlos.infnet.veiculos_service.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("veiculo")
public class Veiculo {

    @Id
    private Long id;

    private String marca;
    private String modelo;
    private int ano;
}