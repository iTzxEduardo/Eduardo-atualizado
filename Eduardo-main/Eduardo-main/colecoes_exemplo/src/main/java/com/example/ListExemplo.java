package com.example;

import java.util.List;
import java.util.ArrayList;


public class ListExemplo {
    private List<String>nomes;

    public ListExemplo() {
        nomes = new ArrayList<>();
    }

    public void adicionarNome(String nome){
        nomes.add(nome);
        System.out.println(nomes.indexOf(nome));
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
    public void modificarNomeIndex(int index, String nome){
        String nomeAnterior = nomes.get(index);
        nomes.set(index,nome);
        System.out.println("Nome da posição "+index+" "+nomeAnterior+", alterado para "+nome);
    }
}
