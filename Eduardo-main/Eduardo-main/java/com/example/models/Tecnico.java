package com.example.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Tecnico {
    private String id;
    private String nome;
    private String especialidade;
    private String disponibilidade;
}
