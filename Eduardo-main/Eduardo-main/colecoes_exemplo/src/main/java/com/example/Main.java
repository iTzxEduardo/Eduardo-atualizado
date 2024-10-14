package com.example;

public class Main {
    public static void main(String[] args) {
        ListExemplo list = new ListExemplo();
        SetExemplo set = new SetExemplo();

        list.adicionarNome("Maria");
        list.adicionarNome("João");
        list.adicionarNome("Pedro");
        list.adicionarNome("José");
        list.listarNomes();
        list.modificarNomeIndex(2, "Carlos");
        list.listarNomes();
        list.deletarNome("João");
        list.listarNomes();
                
        set.adicionarNome("Maria");
        set.adicionarNome("João");
        set.adicionarNome("Pedro");
        set.adicionarNome("José");
        set.listarNomes();
        set.modificarNomeIndex("Pedro", "Carlos");
        set.listarNomes();
        set.deletarNome("João");
        set.listarNomes();
    }
}