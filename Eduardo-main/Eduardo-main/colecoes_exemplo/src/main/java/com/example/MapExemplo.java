package com.example;

import java.util.HashMap;
import java.util.Map;

public class MapExemplo {
    private Map<String,Integer> nomeIdade;

    public MapExemplo(){
        nomeIdade = new HashMap<>();
    }

    public void adicionarNomeIdade(String nome, int idade){
        nomeIdade.put();
    }

    public void listarNomesIdade(){
        for (String  nome : nomeIdade.keySet()) {
            System.out.println(nome + " " +idade);            
        }
    }
}
