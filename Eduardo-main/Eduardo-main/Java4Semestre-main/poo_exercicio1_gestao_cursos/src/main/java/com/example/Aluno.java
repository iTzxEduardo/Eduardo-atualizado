package com.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno extends Pessoa implements Avaliavel{
    private String matricula;
    private double nota;

    //contrutor

    public Aluno(String nome, String cpf, String matricula){
        super(nome, cpf);
        this.matricula = matricula;
        this.nota = 0.0;
    }

    //metodo exibirInfo
    @Override
    public String exibirInfo(){
        super.exibirInfo();
        return "Matricula: " + matricula + " Nota: " + nota;
    }

    @Override
    public String avaliarDesenpenho() {
        if (nota >= 7) {
         return "Aprovado";
        }else if(nota >= 5 && nota <7){
            return "Recuperacao";
        }else{
            return "Reprovado";
        }
    }
}
 