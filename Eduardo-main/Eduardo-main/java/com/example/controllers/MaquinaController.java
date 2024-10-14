package com.example.controllers;

import com.example.api.MaquinaAPI;
import com.example.models.Maquina;

import java.util.List;
import java.util.ArrayList;

public class MaquinaController {
    private List<Maquina> maquinas;

    public MaquinaController() {
        maquinas = new ArrayList<>();
    }

    // Métodos - CRUD
    public void saveMaquina(Maquina maquina) {
        this.maquinas.add(maquina);
    }

    public List<Maquina> readMaquinas() {
        maquinas = MaquinaAPI.getMaquinas();
        return maquinas;
    }

    public void updateMaquina(int posicao, Maquina maquina) {
        maquinas.set(posicao, maquina);
    }

    public void deleteMaquina(int posicao) {
        maquinas.remove(posicao);
    }

    // Novo método para salvar todas as máquinas
    public void saveAllMaquinas() {
        for (Maquina maquina : maquinas) {
            if (maquina.getId() != null && !maquina.getId().isEmpty()) {
                MaquinaAPI.putMaquina(maquina); // Atualiza a máquina existente
            } else {
                Maquina novaMaquina = MaquinaAPI.postMaquina(maquina); // Cria nova máquina
                if (novaMaquina != null) {
                    maquinas.add(novaMaquina); // Adiciona a nova máquina à lista se necessário
                }
            }
        }
    }
}
