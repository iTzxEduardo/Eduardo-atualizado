package com.example;

import java.util.HashSet;
import java.util.Set;

public class SetExemplo {
    private Set<String> nomes;

    public SetExemplo(){
        nomes = new HashSet<>();
    }
     public void adicionarNome(String nome){
        nomes.add(nome);
        System.out.println(nomes.hashCode());
    }

    public void listarNomes(){
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    //remover
    public void deletarNome(String nome){
        nomes.remove(nome);
        System.out.println("Nome removido com sucesso");
    }

    //update
    public void modificarNomeIndex(String nomeNovo, String nome){
        nomes.remove(nome);
        nomes.add(nomeNovo);
        System.out.println("Nome da posição "+nome+" Para "+nomeNovo);
    }
}
