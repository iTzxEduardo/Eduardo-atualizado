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
public class Falha {
    
     private String id;
    private int maquinaId;
    private LocalDate data;
    private String poblema;
    private String prioridade;
    private String operador;
}
