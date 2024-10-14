package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoManutencao {
    
    private String id; // ID como String
    private int maquinaId; // Mantenha o tipo como int, já que no JSON é um número
    private String data;
    private String tipo;
    private String pecasTrocadas;
    private int tempoDeParada; // Tempo de parada como int
    private String tecnicoId; // Mantenha em minúsculas para corresponder ao JSON
    private String observacoes;
}
