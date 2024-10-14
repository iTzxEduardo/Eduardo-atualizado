package com.example.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Maquina {
    
    private String id;
    private String codigo;
    private String nome;
    private String modelo;
    private String fabricante;
    private LocalDate dataAquisicao;
    private int tempoVidaEstimado;
    private String localizacao;
    private String detalhes;
    private String manual;
}
