package com.nfe.low.nfelow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nfe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroNota;
    @Column(name = "razao_social")
    private String razaoSocial;
    @Column(name = "cnpj_empresa")
    private String cnpj;
    @Column(name = "endereco_empresa")
    private String endereco;
    @Column(name = "valor_nfe")
    private double valor;
    @Column(name = "numero_serie_nfe")
    private Long numeroSerie;

}
