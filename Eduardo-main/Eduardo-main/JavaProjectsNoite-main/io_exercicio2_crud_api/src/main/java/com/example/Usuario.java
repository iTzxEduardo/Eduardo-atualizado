package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Usuario {
    private String id;
    private String nome;
    private int idade;
    private String endereco;

    @Override
    public String toString(){
        return "ID: "+id+" Nome: "+nome+" Idade: "+idade;
    }
}
