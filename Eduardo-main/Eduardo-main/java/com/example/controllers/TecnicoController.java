package com.example.controllers;

import com.example.api.TecnicosAPI;
import com.example.models.Tecnico;

import java.util.List;
import java.util.ArrayList;

public class TecnicoController {
    private List<Tecnico> tecnicos;

    public TecnicoController() {
        tecnicos = new ArrayList<Tecnico>();
    }

    // Métodos - CRUD
    public void createTecnico(Tecnico tecnico) {
        this.tecnicos.add(tecnico);
    }

    public List<Tecnico> headTecnicos() {
        tecnicos = TecnicosAPI.getTecnicos(); // Método para buscar técnicos
        return tecnicos;
    }

    public void updateTecnico(int posicao, Tecnico tecnico) {
        this.tecnicos.set(posicao, tecnico);
    }

    public void deleteTecnico(int posicao) {
        this.tecnicos.remove(posicao);
    }
}
