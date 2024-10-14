package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Professor extends Pessoa{
    //Atributo
    private double salario;

    //constutor

    public Professor(String nome, String cpf, double salario){
        super(nome,cpf);
        this.salario = salario;
    }

    //metodos

    @Override
    public String exibirInfo() {
        super.exibirInfo();
        return " Salario: " + salario;
    }
}
