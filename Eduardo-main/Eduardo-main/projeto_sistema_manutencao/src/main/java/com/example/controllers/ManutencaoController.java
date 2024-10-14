package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.ManutencaoAPI;
import com.example.models.Manutencao;

public class ManutencaoController {
    private List<Manutencao> manutencaos;

    public ManutencaoController() {
        manutencaos = new ArrayList<>();
    }

    //métodos - CRUD
    public void createManutencao(Manutencao manutencao){
        ManutencaoAPI.postManutencaos(manutencao);//adicionar a API no Controller
        this.manutencaos.add(manutencao);
    }

    public List<Manutencao> readManutencaos(){
        manutencaos = ManutencaoAPI.getManutencaos();
        return manutencaos;
    }

    public void updateManutencao(int posicao,Manutencao manutencao){
        ManutencaoAPI.putManutencaos(manutencao);//método para atualizar
        manutencaos.set(posicao, manutencao);
    }

    public void deleteManutencao(int posicao){
        manutencaos.remove(posicao);
    }
}
