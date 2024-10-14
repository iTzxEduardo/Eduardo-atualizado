package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.MaquinaAPI;
import com.example.models.Maquina;

public class MaquinaController {
    private List<Maquina> maquinas;

    public MaquinaController() {
        maquinas = new ArrayList<>();
    }

    //métodos - CRUD
    public void createMaquina(Maquina maquina){
        MaquinaAPI.postMaquinas(maquina);//adicionar a API no Controller
        this.maquinas.add(maquina);
    }

    public List<Maquina> readMaquinas(){
        maquinas = MaquinaAPI.getMaquinas();
        return maquinas;
    }

    public void updateMaquina(int posicao,Maquina maquina){
        MaquinaAPI.putMaquinas(maquina);//método para atualizar
        maquinas.set(posicao, maquina);
    }

    public void deleteMaquina(int posicao){
        maquinas.remove(posicao);
    }
}
