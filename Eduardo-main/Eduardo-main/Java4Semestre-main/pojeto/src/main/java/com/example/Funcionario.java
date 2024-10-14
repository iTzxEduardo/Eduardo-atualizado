package com.example;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

    @AllArgsConstructor
    @Getter
    @Setter
public class Funcionario {
    //atributos
    private String nome;
    private int idade;
    private double salario;

    //construtor
            @Override
            public String toString() {
                return "Nome: " + nome + ", Idade: " + idade + ", Salario: " + salario;
            }
    
}
