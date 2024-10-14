package com.example.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Manutencao {
    private String id;
    private String maquinaId;
    private LocalDate data;
    private String tipo;
    private String pecasTrocadas;
    private long tempoParada;
    private String tecnicoId;
    private String observacao;
}
